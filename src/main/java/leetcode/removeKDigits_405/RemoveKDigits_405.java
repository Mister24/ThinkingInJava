/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package leetcode.removeKDigits_405;

/**
 *
 * @author fzw.fzw
 * @version $Id: RemoveKDigits_405.java, v 0.1 2018年08月02日 下午8:00 fzw.fzw Exp $
 */
public class RemoveKDigits_405 {

    public static void main(String[] args) {
        String str = "qw";
    }

    public String removeKdigits(String num, int k) {

        String res = "";
        if (num.length() == 0 || k == 0) {
            return num;
        }

        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) <= num.charAt(i + 1)) {
                i++;
            } else {
                num = num.substring(0, i) + num.substring(i + 1);
                i++;
                k--;
            }
        }
        return res;
    }
}