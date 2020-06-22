package com.nnww.算法;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Level;

public class 排序 {

    @Test
    public void myQuickSort() {

    }


    /**
     * 快速排序
     * 该方法的基本思想是：
     1．先从数列中取出一个数作为基准数。
     2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     3．再对左右区间重复第二步，直到各区间只有一个数。
     */
    @Test
    public void testQuickSort() {
//        int[] numbers = {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 1};
        int[] numbers = {88,73,45,66,56,84,42,19,16,62,88,42,48,46,52,70,39,84,64,82,69,49,39,18,90,69,60,86,90,76,60,59,92,93,76,11,57,21};
        kp(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    private void kp(int[] numbers, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int index = kpcurse(numbers, lowIndex, highIndex);
            kp(numbers, 0, index - 1);
            kp(numbers, index + 1, highIndex);
        }
    }
    /**
     *
     * @param numbers
     * @param low 低位
     * @param high 高位
     */
    private int kpcurse(int[] numbers, int low, int high) {
        int first = numbers[low];
        int currentIndex = high;//当前取值位
        int free = low;//空闲位, 默认以第一个为基准值、空闲位
        while (true) {
            if (low == high) {
                numbers[currentIndex] = first;
                break;
            }
            int n = numbers[currentIndex];
            if (n < first) {
                if (free < currentIndex) {
                    numbers[free] = n;
                    free = currentIndex;
                }
                currentIndex = ++low;
            } else if (n > first) {
                if (free > currentIndex) {
                    numbers[free] = n;
                    free = currentIndex;
                }
                currentIndex = --high;
            } else {
                --high;
                currentIndex = high;
            }
        }
        return currentIndex;
    }

//   ********* 插入排序

    /**
     * 直接插入排序
     * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
     好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
     也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    @Test
    public void test1() {
        int[] NUMBERS = {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 1};
        for (int i = 1; i < NUMBERS.length; i++) {
            int temp = NUMBERS[i];
            int j = i - 1;
            while (j >= 0 && NUMBERS[j] > temp) {
                //将大于temp的值整体后移一个单位
                NUMBERS[j + 1] = NUMBERS[j];
                j--;
            }
            NUMBERS[j + 1] = temp;
        }
        System.out.println(Arrays.toString(NUMBERS));
    }

    /**
     * 简单选择排序
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    @Test
    public void test2() {
        int[] NUMBERS = {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 1};
        int position = 0;
        for (int i = 0; i < NUMBERS.length; i++) {
            int j = i + 1;
            position = i;
            int temp = NUMBERS[i];
            while (j < NUMBERS.length) {
                if (NUMBERS[j] < temp) {
                    temp = NUMBERS[j];
                    position = j;
                }
                j++;
            }
            NUMBERS[position] = NUMBERS[i];
            NUMBERS[i] = temp;
        }
        System.out.println(Arrays.toString(NUMBERS));
    }

    /**
     * 冒泡排序00 从小到大
     * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     */
    @Test
    public void test3() {
        int[] NUMBERS = {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 1};
        int temp;
        for (int i = 0; i < NUMBERS.length - 1; i++) {
            for (int j = 0; j < NUMBERS.length - 1 - i; j++) {
                if (NUMBERS[j] > NUMBERS[j + 1]) {
                    temp = NUMBERS[j];
                    NUMBERS[j] = NUMBERS[j + 1];
                    NUMBERS[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(NUMBERS));
    }


    @Test
    public void test4() {
        int[] NUMBERS = {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 1};
        int length = NUMBERS.length;
        for (int i = 0; i < length; i++) {
            int number1 = NUMBERS[i];
            for (int j = i + 1; j < length; j++) {
                int number2 = NUMBERS[j];
                if (number2 > number1) {
                    NUMBERS[j] = number1;
                    NUMBERS[i] = number2;
                    number1 = number2;
                }
            }
        }
        System.out.println(Arrays.toString(NUMBERS));
    }

}
