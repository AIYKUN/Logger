package com.logger.interf;

import com.logger.core.LogLevel;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public interface ILoggerFormatter {

    public String format(LogLevel level, String log);

    public String format(LogLevel level, String tag, Object object);

    public String format(LogLevel level, String tag, Object object1, Object object2);

    public String format(LogLevel level, String tag, Object[] objects);

    public String format(LogLevel level, String tag, Throwable throwable);
}
