/**
 * fayuan.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package leetcode.medianOfTwoSortedArrays_004;

/**
 *
 * @author fayuan.fzw
 * @version $Id: Solution.java, v 0.1 2018年09月06日 下午10:26 fayuan.fzw Exp $
 */
public class Solution {
    public static void main(String[] args) {

        int[] num1 = {1, 2};
        int[] num2 = {3, 4};

        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] num = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            num[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            num[i + nums1.length] = nums2[i];
        }
        quickSort(num);

        if (num.length % 2 == 0) {
            double res = (num[num.length / 2 - 1] + num[num.length / 2])/ 2.0;

            return res;
        } else {
            double res = num[(num.length - 1) / 2] * 1.0;

            return res;
        }
    }

    public static void quickSort(int[] a) {
        if(a.length>0) {
            quickSort(a, 0 , a.length-1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);
    }

}