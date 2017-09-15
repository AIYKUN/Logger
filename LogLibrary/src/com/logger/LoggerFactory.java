package com.logger;

import com.logger.core.SystemILoggerImpl;
import com.logger.interf.ILogger;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public class LoggerFactory {

    public static ILogger crateLogger(Class<?> testClass) {
        String logName = "logger";
        if(testClass != null) {
            logName = testClass.getSimpleName();
        }
        return crateLogger(logName);
    }

    public static ILogger crateLogger(String tag) {
        return new SystemILoggerImpl(tag);
    }
}
