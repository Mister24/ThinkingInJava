/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.sort;

/**
 * 快速排序
 *
 * @author fayuan.fzw
 * @version $Id: QuickSort.java, v 0.1 2018年03月25日 上午12:11 fayuan.fzw Exp $
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {1, 4 ,65, 34, 9, 45};

        quick(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
        }

    }

    public static int partition(int[] array, int low, int high) {

        int key = array[low];

        while (low < high) {

            //从后向前扫描
            while (array[high] >= key) {
                high --;
            }
            array[low] = array[high];

            //从前向后扫描
            while (array[low] <= key) {
                low ++;
            }
            array[high] = array[low];
        }

        //将基准值存起来
        array[high] = key;

        return high;
    }

    public  static void quick(int[] array, int low, int high) {

        if (low > high) {
            return;
        }

        int index = partition(array, low, high);

        quick(array, low, index - 1);
        quick(array, index + 1, high);
    }
}