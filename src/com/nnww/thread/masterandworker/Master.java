package com.nnww.thread.masterandworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * master-worker设计模式
 * 一个master对应多个worker
 */
public class Master {

    //承接任务的容器
    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();

    //装worker对象的容器
    private HashMap<String, Thread> workers = new HashMap<>();

    //装所有worker执行完成的任务的容器
    private ConcurrentHashMap<String , Object> resultMap = new ConcurrentHashMap<>();

    //构造方法
    public Master(Worker worker, int workerCount) {
//        worker中应该有workQueue,resultMap的引用
        worker.setWorkerQueue(workQueue);
        worker.setResultMap(resultMap);
        for (int i=0; i < workerCount; i++) {
            //key表示每一个worker的名字
            workers.put("子节点" + i, new Thread(worker));
        }
    }

    //提交方法
    public void submit(Task task) {
        this.workQueue.add(task);
    }

    //需要有一个执行的方法(启动全部工作)
    public void execute() {
        Set<Map.Entry<String, Thread>> entries = workers.entrySet();
        for (Map.Entry<String, Thread> entry : entries) {
            entry.getValue().start();
        }
    }

    //判断线程是否走完
    public boolean isComplete() {
        Set<Map.Entry<String, Thread>> entries = workers.entrySet();
        for (Map.Entry<String, Thread> entry : entries) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    //返回结果集数组
    public int getResult() {
        int ret  = 0;
        Set<Map.Entry<String, Object>> entries = resultMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            Integer value = (Integer) entry.getValue();
            ret += value;
        }
        return ret;
    }
}
