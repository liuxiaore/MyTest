package com.nnww.thread.masterandworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> workerQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    @Override
    public void run() {
        //模拟处理任务
        while (true) {
            Task input = workerQueue.poll();//取出并移除一个任务
            if (input == null) {
                break;
            }
            //去执行业务才操作
           Object outPut = handler(input);
           //将执行完成的任务放入resulMap
           resultMap.put(input.getId()+"", outPut);
        }
    }

    private Object handler(Task task) {
        System.out.println("worker正在执行任务");
        int price = task.getPrice();
//        try {
//            //模拟操作耗时
////            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return price;
    }

    public void setWorkerQueue(ConcurrentLinkedQueue<Task> workerQueue) {
        this.workerQueue = workerQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
