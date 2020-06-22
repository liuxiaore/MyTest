package com.nnww.设计模式.Future模式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * futrue 模式
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable callable = new Callable<Chuju>() {
            @Override
            public Chuju call() throws Exception {
                System.out.println("网购厨具下单");
                System.out.println("正在送货.......");
                Thread.sleep(5000);
                return new Chuju();
            }
        };

        FutureTask<Chuju> task = new FutureTask<Chuju>(callable);
        new Thread(task).start();

        // 第二步 去超市购买食材
        System.out.println("正在购买食材");
        Thread.sleep(2000);  // 模拟购买食材时间
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材到位");

        // 第三步 用厨具烹饪食材
        /**
         * * *
         *  task.isDone()
            如果这个任务完成，返回@code true。
             完成可能是由于正常的终止，一个异常，或者
             取消——在所有这些情况下，这个方法会返回
         * {@codetrue}。
         *
         */
        long startTime = System.currentTimeMillis();
        if (!task.isDone()) {
            System.out.println("厨具还没有到达... 那现在我可以根据心情处理是否还继续做饭");
        }
        Chuju chuju = task.get();//这里用时3秒 说明task.get()是阻塞(等待)操作
        System.out.println("等待" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("第三步：厨具到位，开始展现厨艺");
        cook(chuju, shicai);
        System.out.println("总共用时5秒,相比顺序执行节约了两秒");
    }

    //用厨具烹饪食材
    static void cook(Chuju chuju, Shicai shicai) {}

    // 厨具类
    static class Chuju {
    }

    // 食材类
    static class Shicai {
    }
}
