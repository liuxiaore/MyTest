package com.nnww.thread.异步线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SyncService extends Thread {

    private SyncExecutor executor;

    private BlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);

    public SyncService (SyncExecutor syncExecutor) {
        this.executor = syncExecutor;
    }

    public void syncRun() {
        this.start();
    }

    public void run() {
        Object o = executor.execute();
        try {
            this.queue.put(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Object getReturn() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
