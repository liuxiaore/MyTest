package com.nnww.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class TestRobot33 {

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


    public void run() {
        mouseMethod(1044,484);
        mouseMethod(944,484);
        robot.delay(50);
        keyMethod(49);
        robot.delay(50);
        keyMethod(51);
        robot.delay(50);
        keyMethod(54);
        robot.delay(50);
        keyMethod(48);
        robot.delay(50);
        keyMethod(56);
        robot.delay(50);
        keyMethod(50);
        robot.delay(50);
        keyMethod(50);
        robot.delay(50);
        keyMethod(56);
        robot.delay(50);
        keyMethod(50);
        robot.delay(50);
        keyMethod(56);
        robot.delay(50);
        keyMethod(48);
        robot.delay(200);
        mouseMethod(957,540);

    }




    /**
     * 键盘按键
     * @param keyCode
     */
    private void keyMethod(int keyCode) {
        robot.keyPress(keyCode);//按下按键
        robot.delay(KEY_DELEY);//等待时间(按键时长)
        robot.keyRelease(keyCode);//释放按键
    }

    private void mouseMethod(int startX, int startY) {
        robot.mouseMove((int) startX, (int) startY);// 移动到该位置
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);// 按下鼠标
        robot.delay(20);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);// 放开鼠标
    }

    public static void main(String[] args) {
        TestRobot33 testRobot = new TestRobot33();
        robot.delay(3000);
        testRobot.run();
    }
}
