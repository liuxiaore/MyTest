package com.nnww.算法.LeetCode;

import com.mysql.jdbc.EscapeTokenizer;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12] [1,0,0,3,12]
 输出: [1,3,12,0,0]

 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/move-zeroes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 移动零 {
    public static void main(String[] args) {
        移动零 移动零 = new 移动零();
//        int[] nums = {3,6};
        int[] nums = {3,0,6,0,1,0,3,12,0};
        int[] ints = 移动零.test2(nums);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

    private int[] test(int[] nums) {
        int length = nums.length;
        int zeroIndex = 0;
        int zeroCount = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num == 0) {
                zeroIndex = i;
                zeroCount++;
            } else {
                if (zeroCount > 1) {
                    zeroIndex = (zeroIndex + 1) - zeroCount;
                }
                if (zeroCount != 0) {
                    swop(nums, zeroIndex, i);
                }
                zeroIndex = i;
            }
        }
        return nums;
    }

    private int[] test2(int[] nums) {
        int length = nums.length;
        int zeroIndex = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num != 0) {
                swop(nums, i, zeroIndex++);
            }
        }
        return nums;
    }

    private void swop(int[] nums, int i1, int i2) {
        if (i1 == i2) {
            return;
        }
        int temp;
        temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}


