package com.logger.format;

import com.logger.core.LogLevel;
import com.logger.interf.ILoggerFormatter;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public class StringLoggerFormatter implements ILoggerFormatter {

    public String format(LogLevel level, String log) {
        return log;
    }

    public String format(LogLevel level, String tag, Object object) {
        return tag + "|" + object;
    }

    public String format(LogLevel level, String tag, Object object1, Object object2) {
        return tag + "|" + object1 + "|-|" + object2;
    }

    public String format(LogLevel level, String tag, Object[] objects) {
        return tag + "|" + objects;
    }

    public String format(LogLevel level, String tag, Throwable throwable) {
        return tag + "|" + throwable;
    }
}
