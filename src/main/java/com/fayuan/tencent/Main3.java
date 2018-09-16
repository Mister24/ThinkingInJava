/**
 * fayuan.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.tencent;

import java.util.Scanner;

/**
 *
 * @author fayuan.fzw
 * @version $Id: Main3.java, v 0.1 2018年04月05日 下午4:00 fayuan.fzw Exp $
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();

            String[] str = s1.split("\\s");

            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            n = 1;
            m = 20006;

            System.out.println(n + " " + m);
        }
    }
}
