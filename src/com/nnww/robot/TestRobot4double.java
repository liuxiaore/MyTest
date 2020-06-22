package com.nnww.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestRobot4double {

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


    public void run(String phone) {
        mouseMethod(780,537);//最右边光标
        for (int i = 0; i < 15; i++) {//删除之前的输入
            robot.delay(20);
            keyMethod(0x8);
        }
        keyMethods(phone);//输入
        mouseMethod(660,646);//确定
        robot.delay(1000);
        mouseMethod(778,267);//关闭领取过的提示
        robot.delay(500);
        mouseMethod(789,188);//关闭领取成功的提示
        robot.delay(500);
        mouseMethod(780,537);//最右边光标
        //完成以上操作需要3.6秒左右
        robot.delay(1500);//停顿5秒
    }

    public void run2(String phone) {
        mouseMethod(780,537);//最右边光标
        for (int i = 0; i < 15; i++) {//删除之前的输入
            robot.delay(20);
            keyMethod(0x8);
        }
        keyMethods(phone);//输入
        mouseMethod(660,646);//确定
        robot.delay(1000);
        mouseMethod(778,267);//关闭领取过的提示
        robot.delay(500);
        mouseMethod(789,188);//关闭领取成功的提示
        robot.delay(500);
        mouseMethod(780,537);//最右边光标
        //完成以上操作需要3.6秒左右
        robot.delay(1500);//停顿1.5秒
    }

    public ArrayList<String> getPhones() {
        ArrayList<String> strings = new ArrayList<>();
        for (int j = 0; j < 8000; j++) {
            String s = "1581688";
            int i = 1210;
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
    private void keyMethod(int keyCode) {
        robot.keyPress(keyCode);//按下按键
        robot.delay(KEY_DELEY);//等待时间(按键时长)
        robot.keyRelease(keyCode);//释放按键
        robot.delay(50);
    }

    private void keyMethods(String phone) {
        char[] chars = phone.toCharArray();
        for (char aChar : chars) {
            keyMethod((int) aChar);
        }
    }

    private void mouseMethod(int startX, int startY) {
        robot.mouseMove((int) startX, (int) startY);// 移动到该位置
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);// 按下鼠标
        robot.delay(20);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);// 放开鼠标
        robot.delay(50);
    }

    public static void main(String[] args) throws InterruptedException {
        TestRobot4double testRobot = new TestRobot4double();
        robot.delay(1000);
        int count = 0;
//        ArrayList<String> phones = testRobot.getTxtPhone();
        ArrayList<String> phones = testRobot.getPhones();
//        for (String phone : phones) {
//            count++;
//            if (count > 3) {
//                count = 0;
//                testRobot.mouseMethod(837,71);//刷新浏览器
//                robot.delay(700);
//                testRobot.mouseMethod(725,111);//刷新浏览器
//                robot.delay(2000);
//            }
//            testRobot.run(phone);
//        }

        for (int i = 1; i < 100000000; i++) {
            count++;
            if (count > 3) {
                count = 0;
                testRobot.mouseMethod(837,71);//刷新浏览器
                robot.delay(700);
                testRobot.mouseMethod(725,111);//刷新浏览器
                robot.delay(2000);
            }
            testRobot.run(phones.get(i * 2));
            testRobot.run2(phones.get((i * 2) - 1));
        }

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

    public int getKeyCode(int num) {
        int i = 0;
        switch (num) {
            case 0:
                i = 48;
                break;
            case 1:
                i = 49;
                break;
            case 2:
                i = 50;
                break;
            case 3:
                i = 51;
                break;
            case 4:
                i = 52;
                break;
            case 5:
                i = 53;
                break;
            case 6:
                i = 54;
                break;
            case 7:
                i = 55;
                break;
            case 8:
                i = 56;
                break;
            case 9:
                i = 57;
                break;

        }
        return i;
    }
}
