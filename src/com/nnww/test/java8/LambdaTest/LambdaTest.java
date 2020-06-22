package com.nnww.test.java8.LambdaTest;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class LambdaTest {

    @Test
    public void test1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        }).start();

        new Thread(() -> System.out.println("test2")).start();
    }

    /**
     * 迭代
     */
    @Test
    public void Test2() {
        // Java 8之前：
        List<String> features = Arrays.asList(new String[]{"Lambdas", "Default Method", "Stream API", "Date and Time API"});
        for (String feature : features) {
            System.out.println(feature);
        }
        features.forEach(n -> System.out.println(n));

        features.forEach(System.out::println);
    }

    @Test
    public void Test3(){
        List<String> features = Arrays.asList(new String[]{"Lambdas", "Default Method", "Stream API", "Date and Time API"});
    }

    @Test
    public void test4() {
        new Random()
                .ints(1, 10)
                .distinct()
                .limit(5)
                .sorted()
                .forEach(System.out::println);

    }
}
