/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.interview.operationSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 最短寻道优先算法（Shortest Seek Time First）
 *
 * @author fayuan.fzw
 * @version $Id: SSTF.java, v 0.1 2018年03月31日 下午4:24 fayuan.fzw Exp $
 */
public class SSTF {

    public static void main(String[] args) {

        System.out.println("磁道访问列表的书籍为，以空格区分：");
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s");
        List<Integer> list = new ArrayList<>();

        try {
            for (String d : data) {
                list.add(Integer.valueOf(d));
            }
        } catch (Exception e) {
            System.out.println("输入有误，请重新输入");
        }
    }

    public static int[] shortestSeekTimeFirst(int[] data, int begin) {

        int[] result = new int[data.length];

        //Iterator<Integer> integerIterator = result
    }
}