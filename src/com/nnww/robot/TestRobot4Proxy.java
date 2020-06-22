package com.nnww.robot;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 余额宝 单个手机 加代理
 */
public class TestRobot4Proxy {

    //按键间隔
    private static int KEY_DELEY = 50;

    private static Robot robot = null;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestRobot4Proxy testRobot = new TestRobot4Proxy();
        robot.delay(3000);
//        ArrayList<String> phones = testRobot.getTxtPhone();
        //初始化电话号码
        LinkedList<String> phones = testRobot.getPhones();
        //初始化ip
        LinkedList<JSONObject> jsonIps = testRobot.getJsonIps();
        while (true) {
            long start = System.currentTimeMillis();
            if (jsonIps.size() <= 0) {
                jsonIps = testRobot.getJsonIps();
            }
            String phone = getFirstPhone(phones);
            System.out.println("电话"+phone);
            JSONObject jsonIp = getFirstJsonIp(jsonIps);
            String ip = (String) jsonIp.get("Ip");
            Integer port = (Integer) jsonIp.get("Port");
            //检查ip是否可用
            boolean isEnable = checkProxyIp(ip);
            if (isEnable) {
                testRobot.run(phone, ip, port+"");
            }
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    private static JSONObject getFirstJsonIp(LinkedList<JSONObject> jsonIps) {
        return jsonIps.removeFirst();
    }

    private static String getFirstPhone(LinkedList<String> phones) {
        return phones.removeFirst();
    }


    public void run(String phone, String proxyIp, String proxyPort) {
        setProxyIp(proxyIp, proxyPort);
        robot.delay(60000);
        inviteHtml(phone);
    }


    public static void inviteHtml(String phone) {
        mouseMethod(560, 1064);//图标位置
        robot.delay(500);

        mouseMethod(217,720);//关闭领取过的提示
        robot.delay(100);
        mouseMethod(224,684);//关闭领取成功的提示
        robot.delay(100);

        mouseMethod(220,963);//最右边光标
        for (int i = 0; i < 15; i++) {//删除之前的输入
            robot.delay(20);
            keyMethod(0x8);
        }
        keyMethods(phone);//输入
        mouseMethod(135,1012);//确定
        robot.delay(2000);
        mouseMethod(217,720);//关闭领取过的提示
        robot.delay(500);
        mouseMethod(224,684);//关闭领取成功的提示
        robot.delay(500);
    }

    public static int  p1 = 504, p2 = 721;//删除
    public static int  p3 = 609, p4 = 720;//删除
    public static int  p5 = 515, p6 = 1061;//代理图标位置
    public static int  p7 = 386, p8 = 947;//保存
    public static int  p9 = 1676, p10 = 1061;//右下角网络设置
    public static int  p11 = 1700, p12 = 1042;//进入代理设置
    public static int  p13 = 66, p14 = 596;//代理选项
    public static int  p15 = 379, p16 = 654;//开启代理

    public static void setProxyIp(String ip, String port) {
        rightMouseMethod(p9,p10);
        mouseMethod(p11, p12);
        sysSleep(2000);
        mouseMethod(p13, p14);
        sysSleep(1000);
//        mouseMethod(p15, p16);
//        sysSleep(800);
        mouseMethod(p5, p6);
        mouseMethod(p1, p2);
        mouseMethod(p1, p2);
        mouseMethod(p1, p2);
        keyMethods(ip);
        mouseMethod(p3, p4);
        mouseMethod(p3, p4);
        mouseMethod(p3, p4);
        keyMethods(port);
        mouseMethod(p7, p8);
        mouseMethod(p7, p8);
    }

    public static void sysSleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private LinkedList<String> getPhones() {
        LinkedList<String> strings = new LinkedList<>();
        for (int j = 0; j < 8000; j++) {
            String s = "1360822";
            int i = 5801;
            i = i + j;
            s = s + i;
            strings.add(s);
        }
        return strings;
    }


    /**
     * 键盘按键
     * @param keyCode
     */
    public static void keyMethod(int keyCode) {
        robot.keyPress(keyCode);//按下按键
        robot.delay(KEY_DELEY);//等待时间(按键时长)
        robot.keyRelease(keyCode);//释放按键
        robot.delay(50);
    }

    public static void keyMethods(String phone) {
        char[] chars = phone.toCharArray();
        for (char aChar : chars) {
            keyMethod((int) aChar);
        }
    }

    public static void mouseMethod(int startX, int startY) {
        robot.mouseMove((int) startX, (int) startY);// 移动到该位置
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);// 按下鼠标
        robot.delay(20);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);// 放开鼠标
        robot.delay(50);
    }

    public static void rightMouseMethod(int startX, int startY) {
        robot.mouseMove((int) startX, (int) startY);// 移动到该位置
        robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);// 按下鼠标
        robot.delay(20);
        robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);// 放开鼠标
        robot.delay(50);
    }

    public ArrayList<String> getTxtPhone() {
        ArrayList<String> phones = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\liu\\Desktop\\新建文本文档 (2).txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    phones.add(lineTxt.trim());
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
        return phones;
    }


    private LinkedList<JSONObject> getJsonIps() {
        String url = "http://ged.ip3366.net/api/?key=20190124101141879&getnum=30&anonymoustype=4&filter=1&area=1&order=2&formats=2&proxytype=1";
        String body = HttpRequest.get(url).execute().body();
        JSONArray array = null;
        try {
            array = (JSONArray) JSONArray.parse(body);
        } catch (Exception e) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            getJsonIps();
        }
        LinkedList<JSONObject> jsons = new LinkedList<>();
        for (Object o : array) {
            JSONObject json = (JSONObject) o;
            jsons.add(json);
        }
        return jsons;
    }


    public static boolean checkProxyIp(String ip) {
        InputStream is = null;
        BufferedReader reader = null;
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("ping "+ip);
            is = p.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "GBK"));
            String line;
            String time=null;
            String temp=null;
            boolean flag = false;
            while ((line = reader.readLine()) != null) {
    //            line = new String(line.getBytes("GBK"), "UTF-8");
                temp+=line;
                //判断是否丢包
                if(line.indexOf("丢失")>0){
                    flag=false;
                    break;
                }
                //取得延时
                if(line.indexOf("时间")>0&&line.indexOf("ms")>0){
                    time=line.substring(line.indexOf("时间")+3,line.indexOf("ms"));
                    //如果延时小于5秒
                    if(time != null && Integer.valueOf(time)<5000)
                        flag=true;
                    else
                        flag=false;
                    break;
                }
            }
            System.out.println(flag);
            return flag;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                is.close();
                reader.close();
                p.destroy();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
