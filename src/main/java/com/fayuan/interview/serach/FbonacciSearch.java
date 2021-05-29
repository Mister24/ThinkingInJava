/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.serach;

/**
 * 斐波那契查找
 *
 * @author fzw.fzw
 * @version $Id: FbonacciSearch.java, v 0.1 2018年03月21日 下午7:49 fzw.fzw Exp $
 */
public class FbonacciSearch {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(fbonacciSearch(array, 6));
    }

    /**
     * 斐波那契查找
     *
     * @param array  待查找数组
     * @param target 目标数值
     *
     * @return       目标数值在数组中的位置
     *
     * */
    public static int fbonacciSearch(int[] array, int target) {

        if (null == array || array.length == 0 || target > array[array.length - 1] || target < array[0]) {

            return -1;
        } else {

            int middle;
            int position = 0;
            int low = 0;
            int high = array.length - 1;
            int fabonacci[] = new int[array.length];

            //对斐波那契数组赋值
            for (int i = 0; i < array.length; i ++) {
                if (i == 0 || i == 1) {
                    fabonacci[i] = 1;
                } else {
                    fabonacci[i] = fabonacci[i - 1] + fabonacci[i - 2];
                }
            }

            //确定数值在斐波那契数组的数值
            while (array.length - 1 > fabonacci[position]) {
                position ++;
            }

            int[] newArray = new int[fabonacci[position] - 1];
            for (int i = 0; i < newArray.length; i++) {
                if (i < array.length) {
                    newArray[i] = array[i];
                } else {
                    newArray[i] = array[array.length - 1];
                }
            }

            while (low < high) {
                middle = low + fabonacci[position - 1] - 1;
                if (target < newArray[middle]) {
                    high = middle - 1;
                } else if (target > newArray[middle]) {
                    low = middle + 1;
                    position = position - 2;
                } else {
                    if (middle < array.length) {
                        return middle;
                    } else {
                        return array.length - 1;
                    }
                }
            }
        }

        return -1;
    }
}