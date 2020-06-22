package com.nnww.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
//余额宝和支付宝注册 配合手机短息
public class RobotPhone {

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
        RobotPhone testRobot = new RobotPhone();
        robot.delay(1000);
        int count = 0;
//        ArrayList<String> phones = testRobot.getTxtPhone();
        ArrayList<String> phones = testRobot.getPhones();
        for (String phone : phones) {
            count++;
            if (count > 3) {
                count = 0;
                testRobot.mouseMethod(11004,809);//刷新浏览器
                robot.delay(700);
                testRobot.mouseMethod(1000,843);//刷新浏览器
                robot.delay(2000);
            }
            testRobot.run(phone);
        }


    }

    public void run(String phone) {
        mouseMethod(1085,947);//最右边光标
        for (int i = 0; i < 15; i++) {//删除之前的输入
            robot.delay(20);
            keyMethod(0x8);
        }
        keyMethods(phone);//输入
        mouseMethod(1035,976);//确定
        robot.delay(1000);
        mouseMethod(1087,866);//关闭领取过的提示
        robot.delay(500);
        mouseMethod(1090,831);//关闭领取成功的提示
        robot.delay(500);
        mouseMethod(1085,947);//最右边光标
        //完成以上操作需要3.6秒左右
        robot.delay(5000);//停顿5秒
    }

    public ArrayList<String> getPhones() {
        ArrayList<String> strings = new ArrayList<>();
        for (int j = 0; j < 8000; j++) {
            String s = "1862838";
            int i = 1650;
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
