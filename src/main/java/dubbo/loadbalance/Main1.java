/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dubbo.loadbalance;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author fayuan.fzw
 * @version $Id: Main1.java, v 0.1 2018年04月16日 下午7:49 fayuan.fzw Exp $
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        Set<Integer> set = new TreeSet<Integer>();

        while (scanner.hasNext()) {
            int number = Integer.parseInt(scanner.next());

            int[] array = new int[number];

            for (int i = 0; i < number; i++) {
                array[i] = i + 1;
                if (isPrime(array[i])) {
                    set.add(array[i]);
                }

                for (int j = 2; j < 10; j++) {
                    for (int k = 2; k < 10; k++) {
                        if (Math.pow(i, j) < number) {
                            set.add((int)(Math.pow(j, k)));
                        }
                    }
                }
            }

             Object[] numbers = set.toArray();

            System.out.println(0);
        }
    }

    public static boolean isPrime(int number) {

        for (int i = 2; Math.pow(2, i) <= number; i++) {

            return false;
        }
        return true;
    }


}