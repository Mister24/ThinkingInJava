/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dubbo.loadbalance;

import java.util.Scanner;

/**
 *
 * @author fzw.fzw
 * @version $Id: Main.java, v 0.1 2018年04月16日 下午7:02 fzw.fzw Exp $
 */
public class Main {
    public static void main(String[] args) {

        int count = 0;

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String nums = scanner.nextLine();

            String[] numbers = nums.split(" ");

            long a = Integer.valueOf(numbers[0]);
            long b = Integer.valueOf(numbers[1]);
            long c = Integer.valueOf(numbers[2]);

            long result = (long)(Math.pow(2, a) + Math.pow(2, b) - Math.pow(2, c));

            //String str = Long.toBinaryString(result);
            //char[] array = str.toCharArray();
            //
            //for (int i = 0; i < array.length; i++) {
            //    if (array[i] == '1') {
            //        count ++;
            //    }
            //}

            while (result > 0) {
                if ((result & 1) == 1) {
                    ++count;
                }
                result >>= 1;
            }


            System.out.println(count);
        }
    }
}