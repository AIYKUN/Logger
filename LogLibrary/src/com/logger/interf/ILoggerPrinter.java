package com.logger.interf;

import com.logger.core.LogLevel;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public interface ILoggerPrinter {
    ILoggerPrinter CONSOLE = new ILoggerPrinter(){
        @Override
        public void log(LogLevel level, String log) {
            if(level.isEnable()) {
                System.out.println(log);
            }
        }
    };

    ILoggerPrinter ECONSOLE = new ILoggerPrinter(){
        @Override
        public void log(LogLevel level, String log) {
            if(level.isEnable()) {
                System.err.println(log);
            }
        }
    };

    void log(LogLevel level, String log);
}
