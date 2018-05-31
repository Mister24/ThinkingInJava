/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.tencent;

import java.util.Scanner;

/**
 *
 * @author fayuan.fzw
 * @version $Id: Main2.java, v 0.1 2018年04月05日 下午3:24 fayuan.fzw Exp $
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        n = scanner.nextInt();
        int m = 0;
        m = scanner.nextInt();

        long result = 0;

        int flag =  1;
        for (int i = 0; i <= n; i++) {

            result += flag * i ;
            if (i % m == 0) {
                flag = -flag;
            } else {
                flag = flag;
            }
        }
        System.out.println(result);
    }
}