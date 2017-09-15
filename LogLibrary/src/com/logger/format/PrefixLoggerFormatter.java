package com.logger.format;

import com.logger.core.LogLevel;
import com.logger.interf.ILoggerFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public class PrefixLoggerFormatter implements ILoggerFormatter {
    SimpleDateFormat simpleDateFormat;

    public PrefixLoggerFormatter() {
        simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
    }

    private String buildPrefix(LogLevel level) {
        return simpleDateFormat.format(new Date()) + " " + level.name() + " >>> ";
    }

    @Override
    public String format(LogLevel level, String log) {
        return buildPrefix(level) + log;
    }

    @Override
    public String format(LogLevel level, String tag, Object object) {
        return buildPrefix(level) + tag + "|" + object;
    }

    @Override
    public String format(LogLevel level, String tag, Object object1, Object object2) {
        return buildPrefix(level) + tag + "|" + object1 + " || " + object2;
    }

    @Override
    public String format(LogLevel level, String tag, Object[] objects) {
        return buildPrefix(level) + tag + "|" + objects;
    }

    @Override
    public String format(LogLevel level, String tag, Throwable throwable) {
        return buildPrefix(level) + tag + "|" + throwable;
    }
}
