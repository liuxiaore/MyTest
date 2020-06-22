package com.nnww.thread.线程池;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExscutorsTest {


    /**
     * ThreadPoolExecutor 的参数介绍
     * corePoolSize: 核心线程数, 当运行中的线程小于corePoolSize时来一个任务就创建一个线程处理
     * maxinumPoolSize: 当队列(workQueue)已经满时会创建新线程执行任务, 当线程数超过maxinumPoolSize时, 会执行拒绝策略
     * keepAliveTime: 如果当前空闲的线程数超过corePoolSize, 那么空闲超过keepAliveTime时间的线程会被终止
     * workQueue: 任务队列, 一般分为阻塞的无界队列LinkedBlockQueue, 和有界队列ArrayListblockQueue
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8,8,1000, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
//        ThreadPoolExecutor executor = new ThreadPoolExecutor();
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(1);
//            }
//        });
        Future<Integer> submit = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        System.out.println(submit.get());
    }

    public class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test_FixedThreadPool() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        MyTask myTask = new MyTask();
        for (int i = 0; i < 10; i++) {
            executorService.submit(myTask);
        }
        count.await();
    }

    @Test
    public void test3() throws InterruptedException {
//        LinkedBlockingDeque<Object> objects = new LinkedBlockingDeque<>(2);
//        objects.put(1);
//        System.out.println("加入第一个");
//        objects.put(2);
//        System.out.println("加入第2个");

//        LinkedBlockingDeque<Object> objects = new LinkedBlockingDeque<>(2);
//        objects.put(1);
//        System.out.println("加入第一个");
//        System.out.println("拿出一个:" + objects.take());
//        objects.put(2);
//        System.out.println("加入第2个");

        LinkedBlockingDeque<Object> objects = new LinkedBlockingDeque<>(2);


    }

    @Test
    public void test_ScheduledThreadPool() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(1);
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(new MyTask(), 5, TimeUnit.SECONDS);
        cdl.await();
    }

}

