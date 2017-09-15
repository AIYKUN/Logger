package com.logger.printer;

import com.logger.config.LoggerConfig;
import com.logger.core.LogLevel;
import com.logger.log.task.LoggerTask;
import com.logger.interf.ILoggerPrinter;

import java.io.File;

/**
 * Created by aiyongkun on 2017/9/15.
 */
public class FileILoggerPrinter implements ILoggerPrinter {

    private File logFile;

    public FileILoggerPrinter(File file) {
        if(file == null) {
            throw new RuntimeException("log file can not be null");
        }
        this.logFile = file;

        File parent = logFile.getParentFile();
        if (!logFile.exists()) {
            if (parent != null && !parent.exists()) {
                boolean result = parent.mkdirs();
                ILoggerPrinter.CONSOLE.log(LogLevel.SYSTEM, "create file result: " + result);
            } else {
                ILoggerPrinter.CONSOLE.log(LogLevel.SYSTEM, "parent is exists");
            }
        }

    }

    @Override
    public void log(LogLevel level, String log) {
        LoggerConfig.instance().submitTask(new LoggerTask(level, logFile, log));
    }
}