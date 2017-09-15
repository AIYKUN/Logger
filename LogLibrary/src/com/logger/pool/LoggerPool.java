package com.logger.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aiyongkun on 2017/9/15.
 */
public class LoggerPool {

    private ExecutorService mExecutorService;


    public void start() {
        mExecutorService = Executors.newSingleThreadExecutor();
    }

    public void submitTest(Runnable runnable) {
        if(mExecutorService == null || mExecutorService.isTerminated()) {
            mExecutorService = null;
            start();
        }
        mExecutorService.submit(runnable);
    }

    public void stop() {
        if(mExecutorService != null) {
            mExecutorService.shutdown();
        };
        mExecutorService = null;
    }
}
