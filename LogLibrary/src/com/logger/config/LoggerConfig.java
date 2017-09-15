package com.logger.config;

import com.logger.core.LogLevel;
import com.logger.format.StringLoggerFormatter;
import com.logger.interf.ILoggerFormatter;
import com.logger.interf.ILoggerHandler;
import com.logger.interf.ILoggerPrinter;
import com.logger.log.ConsoleLogHandler;
import com.logger.log.task.LoggerTask;
import com.logger.pool.LoggerPool;

import java.io.File;
import java.util.HashMap;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public class LoggerConfig {

    private HashMap<String, ILoggerHandler> logMapping = new HashMap<>();

    //-----------------------------------------------------------------
    private static LoggerConfig pLoggerConfig = new LoggerConfig();
    public static LoggerConfig instance() {
        return pLoggerConfig;
    }

    //-----------------------------------------------------------------
    private LoggerPool mLoggerPool = null;
    private LoggerConfig() {
        mLoggerPool = new LoggerPool();
    }
    public void openLoggerPool() {
        mLoggerPool.start();
    }
    public void closeLoggerPool() {
        mLoggerPool.stop();
    }
    public void submitTask(LoggerTask loggerTask) {
        mLoggerPool.submitTest(loggerTask);
    }

    //-----------------------------------------------------------------
    private File logFolder;
    public void setLogFolder(File folder) {
        logFolder = folder;
    }
    public File createLogFile(String logName) {
        if(logFolder == null) {
            logFolder = new File("/log");
        }

        File file = new File(logFolder, logName);
        ILoggerPrinter.CONSOLE.log(LogLevel.SYSTEM, "logPath:" + file.getAbsolutePath());
        return file;
    }

    //-----------------------------------------------------------------
    public void setDebugEnable(boolean enable) {
        LogLevel.DEBUG.setEnable(enable);
    }
    public void setErrorEnable(boolean enable) {
        LogLevel.ERROR.setEnable(enable);
    }
    public void setInfoEnable(boolean enable) {
        LogLevel.INFO.setEnable(enable);
    }
    public void setTraceEnable(boolean enable) {
        LogLevel.TRACE.setEnable(enable);
    }
    public void setWarnEnable(boolean enable) {
        LogLevel.WARN.setEnable(enable);
    }
    public void setKeepEnable(boolean enable) {
        LogLevel.KEEP.setEnable(enable);
    }

    //-----------------------------------------------------------------
    private ILoggerFormatter loggerFormatter;
    public ILoggerFormatter getLoggerFormatter() {
        synchronized (this) {
            if (loggerFormatter == null) {
                loggerFormatter = new StringLoggerFormatter();
            }
            return loggerFormatter;
        }
    }
    public void setLoggerFormatter(ILoggerFormatter loggerFormatter) {
        synchronized (this) {
            this.loggerFormatter = loggerFormatter;
        }
    }

    //-----------------------------------------------------------------
    public ILoggerHandler getTraceLoggerHandler() {
        return getOrCreateCache(LogLevel.TRACE, ILoggerPrinter.CONSOLE);
    }
    public void setTraceLoggerFace(ILoggerHandler traceLoggerFace) {
        putCache(LogLevel.TRACE, traceLoggerFace);
    }
    public ILoggerHandler getDebugLoggerHandler() {
        return getOrCreateCache(LogLevel.DEBUG, ILoggerPrinter.CONSOLE);
    }
    public void setDebugLoggerHandler(ILoggerHandler debugLoggerFace) {
        putCache(LogLevel.DEBUG, debugLoggerFace);
    }
    public ILoggerHandler getInfoLoggerHandler() {
        return getOrCreateCache(LogLevel.INFO, ILoggerPrinter.CONSOLE);
    }
    public void setInfoLoggerHandler(ILoggerHandler infoLoggerFace) {
        putCache(LogLevel.INFO, infoLoggerFace);
    }
    public ILoggerHandler getErrorLoggerHandler() {
        return getOrCreateCache(LogLevel.ERROR, ILoggerPrinter.CONSOLE);
    }
    public void setErrorLoggerHandler(ILoggerHandler errorLoggerFace) {
        putCache(LogLevel.ERROR, errorLoggerFace);
    }
    public ILoggerHandler getWarnLoggerHandler() {
        return getOrCreateCache(LogLevel.WARN, ILoggerPrinter.CONSOLE);
    }
    public void setWarnLoggerHandler(ILoggerHandler warnLoggerFace) {
        putCache(LogLevel.WARN, warnLoggerFace);
    }
    public ILoggerHandler getKeepLoggerHandler(String tag) {
        return getOrCreateCache(tag, LogLevel.KEEP, ILoggerPrinter.ECONSOLE);
    }
    public void putKeepLoggerHandler(String tag, ILoggerHandler keepLoggerFace) {
        logMapping.put(tag, keepLoggerFace);
    }

    //-----------------------------------------------------------------
    private ILoggerHandler putCache(LogLevel level, ILoggerHandler loggerFace) {
        return logMapping.put(level.name(), loggerFace);
    }
    private ILoggerHandler getOrCreateCache(LogLevel level, ILoggerPrinter defaultPrinter) {
        return getOrCreateCache(level.name(), level, defaultPrinter);
    }
    private ILoggerHandler getOrCreateCache(String tag, LogLevel level, ILoggerPrinter defaultPrinter) {
        ILoggerHandler loggerFace = logMapping.get(tag);
        if(loggerFace == null) {
            loggerFace = new ConsoleLogHandler(defaultPrinter);
            logMapping.put(level.name(), loggerFace);
        }
        return loggerFace;
    }

}
