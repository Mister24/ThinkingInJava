/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.topK;

/**
 *
 * @author fzw.fzw
 * @version $Id: BitMapSort.java, v 0.1 2018年04月05日 下午1:50 fzw.fzw Exp $
 */
public class BitMapSort {

    public static void main(String[] args) {

    }

    public static void bitmapSort(int[] arr) {
        // 找出数组中最值
        int max = arr[0];
        int min = max;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        // 得到位图数组
        int[] newArr = new int[max - min + 1];
        // 重新调整arr中的元素
        int index = 0;
        for (int i = 0; i < newArr.length; i++) {
            while (newArr[i] > 0) {
                arr[index] = i + min;
                index++;
                newArr[i]--;
            }
        }
    }}