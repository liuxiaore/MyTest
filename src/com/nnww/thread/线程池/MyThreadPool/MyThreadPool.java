package com.nnww.thread.线程池.MyThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool {

    private Integer corePoolSize;

    private Integer maxPoolSize;

    private BlockingQueue<Runnable> taskQueue = new LinkedBlockingDeque<>();

    private AtomicInteger runingThread = new AtomicInteger(0);

    /**
     *
     *分三步进行:
     *
     * 1。如果运行的线程小于corePoolSize，请尝试这样做
     *使用给定的命令启动一个新线程
     *任务。对addWorker的调用将自动检查runState和
     * workerCount，这样可以防止添加错误警报
     *线程当它不应该，通过返回false。
     *
     * 2。如果一个任务可以成功排队，那么我们仍然需要
     *再次检查我们是否应该添加一个线程
     *(因为上次检查后现有的已经死了)
     *进入此方法后池关闭。所以我们
     *重新检查状态，如果需要，回滚排队
     *停止，或开始一个新的线程，如果没有。
     *
     * 3。如果无法对任务进行排队，则尝试添加一个新任务
     * 线程。如果它失败了，我们知道我们被关闭或饱和了
     所以拒绝这个任务。
     */
    public void excute(Runnable task) {


        if (runingThread.get() < corePoolSize) {
            addTask(new Work(task));
        }
    }

    private void addTask(Work task) {
//        Thread thread = new Thread(task);
//        runingThread.getAndIncrement();
    }


    class Work implements Runnable {

        private Runnable task;

        public Work(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (runingThread.get() < corePoolSize) {
                        task.run();
                        runingThread.getAndIncrement();
                    } else {
                        Runnable take = taskQueue.take();
                        take.run();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
