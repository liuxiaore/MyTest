package com.nnww.test.My;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MyTest {

     static int i = 1;

    public static void main(String[] args) {
//        String str = "abc.jpg";
//        int i = str.indexOf(".");
//        System.out.println(i);
//        System.out.println(str.substring(i+1));
        System.out.println("ja" + "va" == "java");

    }

    //兔子问题
    @Test
    public void rabbit() {
        int rabbit = funRabbit(10);
        System.out.println(rabbit);
    }
    public static int funRabbit(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return funRabbit(month - 1) + funRabbit(month - 2);
        }
    }

    @Test
    public void test() {

        String s1 = "ab";
        String s2 = new String("ab");
        String s3 = new String ("ab");
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s1==s2);
        System.out.println(s2==s3);

    }

    @Test
    public void test2() {

        int a = 1;
        int b = 2;
        System.out.println(a == b);

        double d = 2.35;
        byte b1 = 1;
        System.out.println(b-b1);
    }

    @Test
    public void test3() {
        double total = 1000000d;
        HongBao hongBao = new HongBao();
        //根据地域的比例来拿自己的值
        //假设四川 0.2
        int sichuan =  10000;
        int timestampValue = 0;
        List<Integer> list = hongBao.splitRedPackets(3600, 60);
        for (Integer integer : list) {
            timestampValue += integer;
            System.out.println(integer + "---" + timestampValue);
        }

    }

    @Test
    public void test4() {
        String str = "{\"name\":\"xiaomimg\",\"age\":\"18\"}";
    }

    @Test
    public void Test5() {
        Double countryAgriRatio = 0.5;
        Double countryNoagriRatio = 0.5;
        Double cityAgriRatio = 0.5;
        Double cityNoAgriRatio = 1.5;
        if (countryAgriRatio < 1d && countryNoagriRatio < 1d && cityAgriRatio < 1d && cityNoAgriRatio < 1d) {
            System.out.println(111);
        }
    }


    @Test
    public void test6() {
        String s = "111-11";
        String[] split = s.split(",");
        System.out.println(s.replaceAll("1-1","2"));


    }

    /**
     * 0 1 2 3 4 5 表示五个方法(五种口碑类型)
     */
    private final static int commentCountOfNative = 0;

    private final static int commentOfProvince = 1;

    private final static int showCommentRandom = 2;

    private final static int commentPraiseRate = 3;

    private final static int koubeiOfUserIdentity = 4;
    @Test
    public void test7() {
        Integer[] methods = {commentCountOfNative, commentOfProvince, showCommentRandom, commentPraiseRate,koubeiOfUserIdentity};
        List<Integer> list = Arrays.asList(methods);
        List<Integer> methodList = new ArrayList<>(list);
        methodList.remove(commentOfProvince);
        for (Integer integer : methodList)
        {
            System.out.println(integer);
        }

    }
}
