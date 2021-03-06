package com.logger.interf;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public interface ILogger {

    String getName();

    boolean isTraceEnabled();

    void trace(String var1);

    void trace(String var1, Object var2);

    void trace(String var1, Object var2, Object var3);

    void trace(String var1, Object[] var2);

    void trace(String var1, Throwable var2);

    boolean isDebugEnabled();

    void debug(String var1);

    void debug(String var1, Object var2);

    void debug(String var1, Object var2, Object var3);

    void debug(String var1, Object[] var2);

    void debug(String var1, Throwable var2);

    boolean isInfoEnabled();

    void info(String var1);

    void info(String var1, Object var2);

    void info(String var1, Object var2, Object var3);

    void info(String var1, Object[] var2);

    void info(String var1, Throwable var2);

    boolean isWarnEnabled();

    void warn(String var1);

    void warn(String var1, Object var2);

    void warn(String var1, Object[] var2);

    void warn(String var1, Object var2, Object var3);

    void warn(String var1, Throwable var2);

    boolean isErrorEnabled();

    void error(String var1);

    void error(String var1, Object var2);

    void error(String var1, Object var2, Object var3);

    void error(String var1, Object[] var2);

    void error(String var1, Throwable var2);

    boolean isKeepEnabled();

    void keep(String tag, Object var2);

    void keep(String tag, Object var2, Object var3);

    void keep(String tag, Object[] var2);

    void keep(String tag, Throwable var2);
}
