package com.nnww.算法.LeetCode;

public class 机器人移动 {

    public void path(int m, int n) {
        int downward = n - 1;
        int right = m - 1;

        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ints[i][j] = j;
            }
        }


    }
}
