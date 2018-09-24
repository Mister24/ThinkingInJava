/**
 * fayuan.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package leetcode.buddyString_859;

import java.util.HashMap;

/**
 *
 * @author fayuan.fzw
 * @version $Id: Solution.java, v 0.1 2018年09月21日 上午12:08 fayuan.fzw Exp $
 */
public class Solution {

    public static void main(String[] args) {

        String A = "aa";
        String B = "aa";

        System.out.println(buddyStrings(A, B));

        HashMap<Integer, Integer> hashMap = new HashMap<>();
    }


    public static boolean buddyStrings(String A, String B) {

        boolean res = true;

        if (A.equals(B) && A.length() >= 2) {
            return true;
        }

        if (A.length() == 0 || B.length() == 0 || A.length() != B.length()) {
            return false;
        }

        char[] chA = A.toCharArray();
        char[] chB = B.toCharArray();

        char[] char_A_diff = new char[2];
        char[] char_B_diff = new char[2];

        int num = 0;
        for (int i = 0; i < chA.length; i++) {
            if (chA[i] != chB[i]) {
                num++;
            }
        }

        if (num != 2) {
            res = false;
        }

        if (num == 2) {
            for (int i = 0; i < chA.length; i++) {
                if (chA[i] != chB[i]) {
                    char_A_diff[num - 2] = chA[i];
                    char_B_diff[num - 2] = chB[i];
                    num ++;
                }
            }

            if (char_A_diff[0] == char_B_diff[1] && char_A_diff[1] == char_B_diff[0]) {
                res = true;
            }
        }

        return res;
    }
}