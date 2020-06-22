package com.nnww.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class TestRobot2 {

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
        //点击深渊炼狱
        mouseMethod(957, 259);
        robot.delay(1000);
//        //选择关卡
//        mouseMethod(startX + , );
//        robot.delay(1000);
//        //确定
//        mouseMethod(, );
//        robot.delay(5000);
//        //前进
//        keyMethod(87); //w 键
//        robot.delay(1000);
//        //鼠标确定
//        mouseMethod(startX + , );
//        robot.delay(2000)
    }

    private void core() {
        while (true) {
            robot.keyPress(87);//按下w按键
            robot.delay(500);//等待时间(按键时长)
            int count = 0;
            //技能输出
            while (count < 800) {
                skillMacro();
                count++;
            }
            keyMethod(88);
            robot.delay(5000);
        }
    }

    /**
     * 技能循环
     */
    private void skillMacro() {
        keyMethod(67);
        keyMethod(73);
        keyMethod(79);
        keyMethod(86);
        keyMethod(80);
        keyMethod(88);
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


    private void test() {
        robot.keyPress(69);//按下按键
        robot.delay(KEY_DELEY);//等待时间(按键时长)
        robot.keyRelease(69);//释放按键
    }
    public static void main(String[] args) {
        TestRobot2 testRobot = new TestRobot2();
//        testRobot.run();
        testRobot.run();
    }
}
