package com.logger.interf;

import com.logger.core.LogLevel;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public interface ILoggerHandler {

    void log(LogLevel level, String log);

    void log(LogLevel level, String tag, Object object);

    void log(LogLevel level, String tag, Object object1, Object object2);

    void log(LogLevel level, String tag, Object[] objects);

    void log(LogLevel level, String tag, Throwable throwable);
}
