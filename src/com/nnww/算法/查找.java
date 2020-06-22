package com.nnww.算法;

import org.junit.Test;

/**
 * 查找算法
 */
public class 查找 {

    /**
     * 二分查找：给定数组是有序的，给定一个key值。每次查找最中间的值，如果相等，就返回对应下标，如果key大于最中间的值，则在数组的右半边继续查找，
     * 如果小于，则在数组左半边查找，。最终有两种结果，一种是找到并返回下标，第二种是没找到。
     */
    @Test
    public void test1() {
        int value = 56;//设要查找56的下标值
        int nums[] = {3,6,7,10,11,16,20,33,56,89};//已经排好序的数组
        int lowIndex = 0;//最小下标
        int highIndex = nums.length - 1;//最大下标
        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;//中间下标
            int middleValue = nums[middleIndex];
            if (middleValue < value) {
                lowIndex = middleIndex + 1;
            } else if (middleValue > value) {
                highIndex = middleIndex - 1;
            } else {
                System.out.println(middleIndex);
                return;
            }
        }
    }



    /**
     * 插值查找
     * 打个比方： 我们在一本英文字典里面查找apple这个单词的时候， 你肯定不会从字典中间开始查找， 而是从字典开头部分开始翻，因为觉得这样的找法才是比较快的。
     这给我提供了一个思路： 如果能在查找前较准确地预测关键字在数组中的位置的话，这样设计出的查找方法能比二分查找提高更多的性能！ 基于这种思想，我们设计了插值查找的算法。
     插值查找和二分查找非常相似， 只要对原代码做少许变动就可以了。
     二分查找中关键的一行代码，是mid = (low + high) / 2， 转变一下就是mid = low + (high - low)/2,   （high-low）后面乘的这1/2就是二分查找每次查找的位置。要实现插值查找，
     只要把这里的1/2替换成我们所预测的关键字的位置占数组总长度的比例就可以了。
     这个比例，可以用公式(key - a[low])/ (a[high] - a[low])来计算， 合起来插值查找对mid的计算公式是：
     mid = low + (high - low)*（key - a[low]）/ (a[high] - a[low])

     注意:前提是数组中元素数值是均匀分布的， 如果是对 1,2,40,99,1000这种分布很不均匀的数组， 插值查找的计算会起到反效果， 就不如二分查找了。
     */
    @Test
    public void test2() {
        int value = 56;//设要查找56的下标值
        int nums[] = {3, 6, 7, 10, 11, 16, 20, 33, 56, 89};//已经排好序的数组
        int lowIndex = 0;//最小下标
        int highIndex = nums.length - 1;//最大下标
        while (nums[lowIndex] != nums[highIndex] && value >= nums[lowIndex] && value <= nums[highIndex]) {
            int middleIndex = lowIndex + (highIndex - lowIndex) * (value - nums[lowIndex]) / (nums[highIndex] - nums[lowIndex]);
            if (value < nums[middleIndex]) {
                highIndex = middleIndex - 1;
            } else if (value > nums[middleIndex]) {
                lowIndex = middleIndex + 1;
            } else {
                System.out.println(middleIndex);
                return;
            }
        }
    }



    /**
     *
     */
    @Test
    public void test3() {
    }
}
