package com.logger.core;

/**
 * Created by aiyongkun on 2017/9/15.
 */
public enum LogLevel {
    SYSTEM(true),
    TRACE(false),
    DEBUG(true),
    INFO(false),
    WARN(false),
    ERROR(false),
    KEEP(false);

    LogLevel(boolean enable) {
        this.enable = enable;
    }

    boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
