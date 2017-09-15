package com.logger.core;

import com.logger.config.LoggerConfig;
import com.logger.interf.ILogger;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public final class SystemILoggerImpl implements ILogger {

    private String className;

    public SystemILoggerImpl(String className) {
        this.className = className;
    }

    @Override
    public String getName() {
        return className;
    }

    @Override
    public boolean isTraceEnabled() {
        return LogLevel.TRACE.isEnable();
    }

    @Override
    public void trace(String var1) {
        LoggerConfig.instance().getTraceLoggerHandler().log(LogLevel.TRACE, var1);
    }

    @Override
    public void trace(String var1, Object var2) {
        LoggerConfig.instance().getTraceLoggerHandler().log(LogLevel.TRACE, var1, var2);
    }

    @Override
    public void trace(String var1, Object var2, Object var3) {
        LoggerConfig.instance().getTraceLoggerHandler().log(LogLevel.TRACE, var1, var2, var3);
    }

    @Override
    public void trace(String var1, Object[] var2) {
        LoggerConfig.instance().getTraceLoggerHandler().log(LogLevel.TRACE, var1, var2);
    }

    @Override
    public void trace(String var1, Throwable var2) {
        LoggerConfig.instance().getTraceLoggerHandler().log(LogLevel.TRACE, var1, var2);
    }

    @Override
    public boolean isDebugEnabled() {
        return LogLevel.DEBUG.isEnable();
    }

    @Override
    public void debug(String var1) {
        LoggerConfig.instance().getDebugLoggerHandler().log(LogLevel.DEBUG, var1);
    }

    @Override
    public void debug(String var1, Object var2) {
        LoggerConfig.instance().getDebugLoggerHandler().log(LogLevel.DEBUG, var1, var2);
    }

    @Override
    public void debug(String var1, Object var2, Object var3) {
        LoggerConfig.instance().getDebugLoggerHandler().log(LogLevel.DEBUG, var1, var2, var3);
    }

    @Override
    public void debug(String var1, Object[] var2) {
        LoggerConfig.instance().getDebugLoggerHandler().log(LogLevel.DEBUG, var1, var2);
    }

    @Override
    public void debug(String var1, Throwable var2) {
        LoggerConfig.instance().getDebugLoggerHandler().log(LogLevel.DEBUG, var1, var2);
    }

    @Override
    public boolean isInfoEnabled() {
        return LogLevel.INFO.isEnable();
    }

    @Override
    public void info(String var1) {
        LoggerConfig.instance().getInfoLoggerHandler().log(LogLevel.INFO, var1);
    }

    @Override
    public void info(String var1, Object var2) {
        LoggerConfig.instance().getInfoLoggerHandler().log(LogLevel.INFO, var1, var2);
    }

    @Override
    public void info(String var1, Object var2, Object var3) {
        LoggerConfig.instance().getInfoLoggerHandler().log(LogLevel.INFO, var1, var2, var3);
    }

    @Override
    public void info(String var1, Object[] var2) {
        LoggerConfig.instance().getInfoLoggerHandler().log(LogLevel.INFO, var1, var2);
    }

    @Override
    public void info(String var1, Throwable var2) {
        LoggerConfig.instance().getInfoLoggerHandler().log(LogLevel.INFO, var1, var2);
    }

    @Override
    public boolean isWarnEnabled() {
        return LogLevel.WARN.isEnable();
    }

    @Override
    public void warn(String var1) {
        LoggerConfig.instance().getWarnLoggerHandler().log(LogLevel.WARN, var1);
    }

    @Override
    public void warn(String var1, Object var2) {
        LoggerConfig.instance().getWarnLoggerHandler().log(LogLevel.WARN, var1, var2);
    }

    @Override
    public void warn(String var1, Object[] var2) {
        LoggerConfig.instance().getWarnLoggerHandler().log(LogLevel.WARN, var1, var2);
    }

    @Override
    public void warn(String var1, Object var2, Object var3) {
        LoggerConfig.instance().getWarnLoggerHandler().log(LogLevel.WARN, var1, var2, var3);
    }

    @Override
    public void warn(String var1, Throwable var2) {
        LoggerConfig.instance().getWarnLoggerHandler().log(LogLevel.WARN, var1, var2);
    }

    @Override
    public boolean isErrorEnabled() {
        return LogLevel.ERROR.isEnable();
    }

    @Override
    public void error(String var1) {
        LoggerConfig.instance().getErrorLoggerHandler().log(LogLevel.ERROR, var1);
    }

    @Override
    public void error(String var1, Object var2) {
        LoggerConfig.instance().getErrorLoggerHandler().log(LogLevel.ERROR, var1,var2);
    }

    @Override
    public void error(String var1, Object var2, Object var3) {
        LoggerConfig.instance().getErrorLoggerHandler().log(LogLevel.ERROR, var1,var2, var3);
    }

    @Override
    public void error(String var1, Object[] var2) {
        LoggerConfig.instance().getErrorLoggerHandler().log(LogLevel.ERROR, var1,var2);
    }

    @Override
    public void error(String var1, Throwable var2) {
        LoggerConfig.instance().getErrorLoggerHandler().log(LogLevel.ERROR, var1,var2);
    }

    @Override
    public boolean isKeepEnabled() {
        return LogLevel.KEEP.isEnable();
    }

    @Override
    public void keep(String tag, Object var2) {
        LoggerConfig.instance().getKeepLoggerHandler(tag).log(LogLevel.KEEP, tag, var2);
    }

    @Override
    public void keep(String tag, Object var2, Object var3) {
        LoggerConfig.instance().getKeepLoggerHandler(tag).log(LogLevel.KEEP, tag, var2, var3);

    }

    @Override
    public void keep(String tag, Object[] var2) {
        LoggerConfig.instance().getKeepLoggerHandler(tag).log(LogLevel.KEEP, tag, var2);
    }

    @Override
    public void keep(String tag, Throwable var2) {
        LoggerConfig.instance().getKeepLoggerHandler(tag).log(LogLevel.KEEP, tag, var2);
    }
}
