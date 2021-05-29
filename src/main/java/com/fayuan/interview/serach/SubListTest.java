/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.interview.serach;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fzw.fzw
 * @version $Id: SubListTest.java, v 0.1 2018年06月07日 下午1:21 fzw.fzw Exp $
 */
public class SubListTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("a");

        // 使用构造器创建一个包含list的列表list1
        List<String> list1 = new ArrayList<String>(list);
        // 使用subList生成与list相同的列表list2
        List<String> list2 = list.subList(0, list.size());
        list1.add("b");

        System.out.println(list.equals(list1));
        System.out.println(list.equals(list2));
    }
}