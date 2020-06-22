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
import java.util.LinkedList;

/**
 * 哈啰单车邀请新人 加 支付宝邀请   加代理
 */
public class RobotHProxy {

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
        RobotHProxy testRobot = new RobotHProxy();
        robot.delay(5000);
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
        robot.delay(20000);
        inviteHtmlYuEBao(phone);
//        inviteHtmlHelloBIke(phone);
    }

    public static void inviteHtmlHelloBIke(String phone) {
        mouseMethod(415, 751);//图标位置
        robot.delay(500);
        mouseMethod(365, 660);//图标位置
        robot.delay(500);
        mouseMethod(1277,476);//最右边光标
        for (int i = 0; i < 15; i++) {//删除之前的输入
            robot.delay(20);
            keyMethod(0x8);
        }
        keyMethods(phone);//输入
        mouseMethod(1204,530);//确定
        robot.delay(2000);
        mouseMethod(1116,67);//刷新
        robot.delay(500);
    }

    public static void inviteHtmlYuEBao(String phone) {
        mouseMethod(366, 746);//图标位置
        robot.delay(1000);
        mouseMethod(54,49);//刷新
        robot.delay(500);
        mouseMethod(363,433);//最右边光标
        for (int i = 0; i < 15; i++) {//删除之前的输入
            robot.delay(20);
            keyMethod(0x8);
        }
        keyMethods(phone);//输入
        mouseMethod(276,489);//确定
        robot.delay(2000);
        mouseMethod(54,49);//刷新
        robot.delay(500);
    }

    public static int  p1 = 504, p2 = 429;//删除
    public static int  p3 = 608, p4 = 429;//删除
    public static int  p5 = 378, p6 = 364;//代理图标位置
    public static int  p7 = 387, p8 = 659;//保存
    public static int  p9 = 1124, p10 = 748;//右下角网络设置
    public static int  p11 = 1152, p12 = 723;//进入代理设置
    public static int  p13 = 100, p14 = 600;//代理选项
    public static int  p15 = 379, p16 = 654;//开启代理

    public static void setProxyIp(String ip, String port) {
        rightMouseMethod(p9,p10);
        mouseMethod(p11, p12);
        sysSleep(2000);
        mouseMethod(p13, p14);
        sysSleep(1000);
//        mouseMethod(p15, p16);
//        sysSleep(800);
        //向下滑动鼠标
        mouseMethod(937, 314);
        sysSleep(50);
        mouseWheelMethod(50);
        sysSleep(1000);
//        mouseMethod(p5, p6);
//        sysSleep(1000);
//        mouseMethod(p5, p6);
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
            String s = "1832873";
            int i = 1689;
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
        String url = "http://ged.ip3366.net/api/?key=20190124101141879&getnum=30&anonymoustype=4&area=1&formats=2&proxytype=1";
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



    /**
     * //鼠标滚轮
     *  如果此参数小于0,则表示向上滚动滑轮

     如果此参数大于0,则表示向下滚动滑轮
     */
    public static void mouseWheelMethod(int param) {
        robot.mouseWheel(param);
        robot.delay(100);
    }

}
