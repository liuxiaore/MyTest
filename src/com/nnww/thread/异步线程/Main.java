package com.nnww.thread.异步线程;

public class Main {

    public static class SyncTask implements SyncExecutor {

        @Override
        public Object execute() {
            System.out.println("任务中");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 8888;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        SyncService syncService = new SyncService(new SyncTask());
        syncService.syncRun();
        System.out.println("do something.....");Thread.sleep(4000);
        Object o = syncService.getReturn();
        System.out.println("end: " + o);
    }
}
