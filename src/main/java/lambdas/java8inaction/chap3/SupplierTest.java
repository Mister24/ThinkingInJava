/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap3;

import lambdas.java8inaction.chap2.User;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author mr.24
 * @version Id: SupplierTest, v 1.0 2021/6/1 12:04 上午 Exp $$
 */
public class SupplierTest {
    public static void main(String[] args) {

        /**
         * There is no requirement that a new or distinct result be returned each
         * time the supplier is invoked.
         */
        Supplier<User> supplier = new Supplier<User>() {
            @Override
            public User get() {
                return User.builder().name(String.valueOf(new Random().nextInt())).country("China").build();
            }
        };


        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }


}
