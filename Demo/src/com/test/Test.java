package com.test;

import com.logger.log.FileLogHandler;
import com.logger.printer.FileILoggerPrinter;
import com.logger.format.PrefixLoggerFormatter;
import com.logger.interf.ILogger;
import com.logger.config.LoggerConfig;
import com.logger.LoggerFactory;

import java.io.File;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public class Test {

    /**
     * 设置日志开关，默认开启了系统控制台日志，Debug日志，其他均没有开启
     */
    private static void setUpEnable(LoggerConfig config) {
        config.setDebugEnable(true);
        config.setInfoEnable(true);
        config.setErrorEnable(true);
        config.setKeepEnable(true);
    }

    /**
     * 设置日志保存文件，默认都不保存文件，只是控制台显示[前提是开启了对应的开关或者系统日志开关]
     */
    private static void installSameLog(LoggerConfig config) {
        config.setLogFolder(new File("d:/log"));
        //支持定向到文件,默认不会定位到文件，而是控制台或者自定义日志处理器
        config.setDebugLoggerHandler(new FileLogHandler("debug.log"));
        config.setErrorLoggerHandler(new FileLogHandler("aaaa.log"));
        config.setInfoLoggerHandler(new FileLogHandler("aaaa.log"));
//        config.setWarnLoggerHandler(new FileLogHandler("aaaa.log"));
        //设置分类TAG日志文件,保存时按TAG保存
        config.putKeepLoggerHandler("AAAA", new FileLogHandler("aaaa.log"));
        config.putKeepLoggerHandler("BBBB", new FileLogHandler("aaaa.log"));
        config.putKeepLoggerHandler("DDDD", new FileLogHandler(new FileILoggerPrinter(
                LoggerConfig.instance().createLogFile("aaaa.log"))));

    }

    /**
     * 设置日志格式化工具
     */
    private static void installLogFormatter(LoggerConfig config) {
        config.setLoggerFormatter(new PrefixLoggerFormatter());
    }

    public static void main(String[] args) {
        LoggerConfig config = LoggerConfig.instance();

        setUpEnable(config);
        installSameLog(config);
        installLogFormatter(config);

        ILogger logger = LoggerFactory.crateLogger(Test.class);

        logger.debug("tag", 223);
        logger.error("here pring the error log");
        logger.info("test", new Exception("sdfsdkjfksdjfsdjfk"));
        logger.debug("debug log is opened");
        logger.info("class name: " + logger.getName());

        logger.keep("AAAA", "sdfsd");
        logger.keep("BBBB", "sdfsd");
        logger.keep("cccc", "sdfsd");
        logger.debug("AAAA", "ddddddd");
        logger.keep("AAAA", "pay the fee for book");
        logger.keep("DDDD", "THIS LOG IS BELONG TO DDDD!");

        LoggerConfig.instance().closeLoggerPool();
    }
}
