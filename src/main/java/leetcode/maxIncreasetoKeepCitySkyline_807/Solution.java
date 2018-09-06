/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package leetcode.maxIncreasetoKeepCitySkyline_807;

/**
 *
 * @author fayuan.fzw
 * @version $Id: Solution.java, v 0.1 2018年08月26日 上午10:34 fayuan.fzw Exp $
 */
public class Solution {

    public static void main(String[] args) {

        int[][] demo = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(demo));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        int[][] max = new int[grid.length][grid[0].length];

        //列数量
        int col = grid.length;
        //行数量
        int row = grid[0].length;
        int temp = 0;
        int tem = 0;
        //列最大数组
        int[] colMax = new int[row];
        //行最大数组
        int[] rowMax = new int[col];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                temp = grid[i][0];
                colMax[i] = temp > grid[i][j] ? temp : grid[i][j];
                tem = grid[0][j];
                rowMax[j] = tem > grid[i][j] ? tem : grid[i][j];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                max[i][j] = rowMax[i] > colMax[j] ? colMax[j] : rowMax[i];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                result += max[i][j] - grid[i][j];
            }
        }
        return result;
    }

}