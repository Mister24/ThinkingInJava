/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.exchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fzw.fzw
 * @version $Id: Solution.java, v 0.1 2018年04月05日 下午1:58 fzw.fzw Exp $
 */
public class Solution {

    public static void main(String[] args) {

        //数组->list
        String[] array = {"123", "234", "456"};
        List<String> list = Arrays.asList(array);

        //list->数组
        List<String> list1 = new ArrayList<String>();
        list.add("123");
        list.add("234");
        //String[] strings = list.toString(new String(list1.size()));

        //字符串去空格
        String str = "h ee ll o";
        String str1 = str.replace(" ", "");
        System.out.println(str1);
    }

    //实现最近浏览商品ID存储（ID已经存在的，把原来位置的去掉，在最后重新加入；原来不存在的则直接在最后加入）
    public static String save(String s,String id){
        //这里还应该判断商品ID是否已经存在于list当中，如果存在，则删除原来ID，在最后添加上商品ID
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            list.append(s.charAt(i));
        }
        int index = list.indexOf(id);
        if(index != -1){
            list.delete(index,index+2);
        }
        list.append(id+",");
        s = list.toString();
        return s;
    }

}
