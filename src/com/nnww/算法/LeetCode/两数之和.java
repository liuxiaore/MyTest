package com.nnww.算法.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数之和 {

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] ints = 两数之和.twoSum(nums, target);
        System.out.println(ints);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, i);
            int temp = target - num;
            if (temp == num) {
                continue;
            }
            if (map.containsKey(temp)) {
                ints[0] = map.get(temp);
                ints[1] = i;
                break;
            }
        }
        return ints;
    }

//    public static int[] twoSum(int[] nums, int target) {
//        int[] ints = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            for (int j = 0; j < nums.length; j++) {
//                int num2 = nums[j];
//                if (i == j) {
//                    continue;
//                }
//                if ((num + num2) == target) {
//                    ints[0] = i;
//                    ints[1] = j;
//                    break;
//                }
//            }
//        }
//        return ints;
//    }


}
