package com.logger.core;

import com.logger.config.LoggerConfig;
import com.logger.interf.ILoggerHandler;
import com.logger.interf.ILoggerFormatter;
import com.logger.interf.ILoggerPrinter;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public abstract class AbsLoggerHandler implements ILoggerHandler {

    private ILoggerFormatter loggerFormatter;
    private ILoggerPrinter loggerPrinter;

    public AbsLoggerHandler(ILoggerPrinter printer) {
        loggerPrinter = printer;
    }

    private ILoggerPrinter getLoggerPrinter() {
        if(loggerPrinter == null) {
            loggerPrinter = ILoggerPrinter.CONSOLE;
        }
        return loggerPrinter;
    }

    private ILoggerFormatter getLoggerFormatter() {
        if(loggerFormatter == null) {
            loggerFormatter = LoggerConfig.instance().getLoggerFormatter();
        }
        return loggerFormatter;
    }

    @Override
    public void log(LogLevel level, String log) {
        if (level.isEnable()) {
            getLoggerPrinter().log(level, getLoggerFormatter().format(level, log));
        } else {
            ILoggerPrinter.ECONSOLE.log(LogLevel.SYSTEM, getLoggerFormatter().format(level, log));
        }
    }

    @Override
    public void log(LogLevel level, String tag, Object object) {
        if (level.isEnable()) {
            getLoggerPrinter().log(level, getLoggerFormatter().format(level, tag, object));
        } else {
            ILoggerPrinter.ECONSOLE.log(LogLevel.SYSTEM, getLoggerFormatter().format(level, tag, object));
        }
    }

    @Override
    public void log(LogLevel level, String tag, Object object1, Object object2) {
        if (level.isEnable()) {
            getLoggerPrinter().log(level, getLoggerFormatter().format(level, tag, object1, object2));
        } else {
            ILoggerPrinter.ECONSOLE.log(LogLevel.SYSTEM, getLoggerFormatter().format(level, tag, object1, object2));
        }
    }

    @Override
    public void log(LogLevel level, String tag, Object[] objects) {
        if (level.isEnable()) {
            getLoggerPrinter().log(level, getLoggerFormatter().format(level, tag, objects));
        } else {
            ILoggerPrinter.ECONSOLE.log(LogLevel.SYSTEM, getLoggerFormatter().format(level, tag, objects));
        }
    }

    @Override
    public void log(LogLevel level, String tag, Throwable throwable) {
        if (level.isEnable()) {
            getLoggerPrinter().log(level, getLoggerFormatter().format(level, tag, throwable));
        } else {
            ILoggerPrinter.ECONSOLE.log(LogLevel.SYSTEM, getLoggerFormatter().format(level, tag, throwable));
        }
    }
}
