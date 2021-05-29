/**
 * fzw.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package leetcode.longestSubstringWithoutRepeatingCharacters_003;

import java.util.HashMap;

/**
 * 最长无重复子序列的长度
 *
 * @author fzw.fzw
 * @version $Id: Solution.java, v 0.1 2018年08月22日 下午11:55 fzw.fzw Exp $
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("result : " + lengthOfLongestSubstring("nfpdmpi"));
    }


    /**
     * 求解最大无重复子序列的长度
     *
     * 维护一个滑动窗口字符串
     * 如果右侧新加入的字符不在hashmap中，则加入，同时将之前的长度结果和当前的长度值进行大小比较，保留较大结果
     * 如果右侧加入的字符已经在hashmap中，从字符串的对应下标开始使用substring进行截取，同时将之前的长度结果和当前的长度值
     * 进行大小比较，保留较大的数值。
     *
     * @param s 待求解的字符串
     *
     * */
    public static int lengthOfLongestSubstring(String s) {

        int num = 0;
        String str = "";
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                System.out.println("12:" + str.indexOf(s.charAt(i)));
                str = str.substring(str.indexOf(s.charAt(i)) + 1);
                str += s.charAt(i);

                if (str.length() > num) {
                    num = str.length();
                }
            } else {
                str += s.charAt(i);
                hashMap.put(s.charAt(i), 1);
                if (str.length() > num) {
                    num = str.length();
                }

            }
        }

        return num;
    }
}