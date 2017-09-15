package com.logger.log;

import com.logger.config.LoggerConfig;
import com.logger.core.AbsLoggerHandler;
import com.logger.printer.FileILoggerPrinter;

import java.io.File;

/**
 * Created by aiyongkun on 2017/9/14.
 */
public final class FileLogHandler extends AbsLoggerHandler {

    public FileLogHandler(String fileName) {
        this(LoggerConfig.instance().createLogFile(fileName));
    }

    public FileLogHandler(File logFile) {
        this(new FileILoggerPrinter(logFile));
    }

    public FileLogHandler(FileILoggerPrinter fileLoggerPrinter) {
        super(fileLoggerPrinter);
    }
}
