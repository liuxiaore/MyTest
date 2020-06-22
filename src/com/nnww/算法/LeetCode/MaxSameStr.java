package com.nnww.算法.LeetCode;

/**
 * 找出两个字符串中的最大子串：例s1="asdafghjka", s2="aaasdfg"    他们的最大子串为"asd"  

 这个题类似与字符串匹配的问题，首先因想到用长的字符串判断是否包含短的字符串

 高效的做法是：依次把短的字符串的长度递减，找出短的字符串的子字符串，这样就大大提高了效率

 减少了比较的次数。

 例：1.短的长度为 0~s2.lengh() 与长的判断一次（判断是否包含）；

        2..短的长度为 0~s2.lengh()-1 与长的判断两次（有两个长度为s2.lengh()-1在短的字符串中）

        3..短的长度为 0~s2.lengh()-2 与长的判断三次；

        4..短的长度为 0~s2.lengh()-3 与长的判断四次；

 所以应写出把短的字符串遍历的代码；通过以上规律即可写出
 */
public class MaxSameStr {

    public static void main(String[] args) {
        String s1="asdafghjka";
        String s2="aaasdfg";
        System.out.println(test(s1, s2));
    }


    public static String test(String s1, String s2) {
        if (s1.equals(s2)) {
            return s1;
        }
        String max = s1.length() < s2.length() ? s2 : s1;
        String min = s1.length() < s2.length() ? s1 : s2;

        int minlength = min.length();
        for (int i = 0; i < minlength; i++) {
            int strTempIndex = minlength - i;
            for (int j = 0; j <= i; j++) {
                String resultStr = min.substring(j, strTempIndex + j);
                if (max.contains(resultStr)) {
                    return resultStr;
                }
            }

        }
        return null;
    }



}
