package com.logger.log.task;

import com.logger.core.LogLevel;
import com.logger.interf.ILoggerPrinter;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by aiyongkun on 2017/9/15.
 */
public class LoggerTask implements Runnable {
    private LogLevel level;
    private File logFile;
    private String log;

    public LoggerTask(LogLevel level, File logFile, String log) {
        this.level = level;
        this.logFile = logFile;
        this.log = log;
    }

    @Override
    public void run() {
        try {
            ILoggerPrinter.CONSOLE.log(LogLevel.SYSTEM, log);

            FileWriter writer = new FileWriter(logFile, true);
            writer.write(log + "\r\n");
            writer.close();
        } catch (Exception e) {
            ILoggerPrinter.ECONSOLE.log(LogLevel.SYSTEM, log);
        }
    }
}
