/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.tencent;

import java.util.Scanner;

/**
 *
 * @author fayuan.fzw
 * @version $Id: Main4.java, v 0.1 2018年04月05日 下午6:02 fayuan.fzw Exp $
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //n: 天数
        //m：巧克力个数
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        int result = 0;
        //if ()
        result = (int)(0.5 * m * ( 1.0 - Math.pow(0.5, n)));

        System.out.println(result);
    }
}