package com.logger.log;

import com.logger.core.AbsLoggerHandler;
import com.logger.interf.ILoggerPrinter;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public final class ConsoleLogHandler extends AbsLoggerHandler {
    public ConsoleLogHandler(ILoggerPrinter printer) {
        super(printer);
    }
}
