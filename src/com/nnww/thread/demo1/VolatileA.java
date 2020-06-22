package com.nnww.thread.demo1;

public class VolatileA implements Runnable {

    private boolean isContinue  = true;

    @Override
    public void run() {
        pritName();
    }

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public void pritName() {
        while (isContinue) {
            System.out.println("-------  " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
