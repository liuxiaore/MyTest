package com.nnww.thread.masterandworker;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Master master = new Master(new Worker(), 10);//这里应该用线程池,不是随意的
        Random random = new Random();
        for (int i=0; i < 100; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("任务" + i);
            task.setPrice(random.nextInt() * 1000);
            master.submit(task);
        }
        master.execute();

        while (true) {
            if (master.isComplete()) {
                long set = master.getResult();
                System.out.println(set);
                break;
            }
        }
    }
}
