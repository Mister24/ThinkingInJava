/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.serach;

/**
 * 二分查找（递归 + 非递归）
 *
 * @author fzw.fzw
 * @version $Id: BinarySearch.java, v 0.1 2018年03月21日 下午12:43 fzw.fzw Exp $
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 3, 5, 7, 9};
        System.out.println(binarySesarch(array, 3));
        System.out.println(binarySearch(array, 7, 0, array.length - 1));
    }

    /**
     * 二分查找（非递归）
     * 查询到则返回其在数组中的下标，否则返回-1
     *
     * @param array  待查找数组
     * @param target 目标数值
     *
     * @return       目标数值在数组中的位置
     * */
    public static int binarySesarch(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找（递归）
     * 查询到则返回其在数组中的下标，否则返回-1
     *
     * @param array  待查找数组
     * @param target 目标数值
     * @param begin  查询开始位置
     * @param end    查询结束位置
     *
     * @return       目标数值在数组中的位置
     * */
    public static int binarySearch(int[] array, int target, int begin, int end) {

        int middle = (begin + end) / 2;

        if (target < array[begin] || target > array[end]) {
            return -1;
        }

        if (target < array[middle]) {
            return binarySearch(array, target, begin, middle - 1);
        } else if (target > array[middle]) {
            return binarySearch(array, target, middle + 1, end);
        } else {
            return middle;
        }
    }
}