package corejava.chapter05.wrapper;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = Lists.newArrayListWithCapacity(8);
        // 自动装箱
        arrayList.add(3);
        arrayList.add(Integer.valueOf(3));

        // 自动拆箱[先拆箱，再自增，再装箱]
        Integer from = 1;
        from++;
        System.out.println(from);

        //
        Integer integer = 1;
        Double x = 2.0;
        System.out.println(true ? integer : x);

    }
}
