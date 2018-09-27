/**
 * fayuan.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.apache.commons.lang.time;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author fayuan.fzw
 * @version $Id: TestList.java, v 0.1 2018年05月30日 下午9:30 fayuan.fzw Exp $
 */
public class TestList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("q");
        list.add("q");
        list.add("w");
        list.add("r");

        List<String> list1 = removeDuplicate(list);

        for (String str : list1) {
            System.out.println(str);
        }
    }

    /**
     * list集合去重
     *
     * @param list 需要去重的list
     *
     * @return     去重之后的list
     * */
    public static List removeDuplicate(List list) {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }

}