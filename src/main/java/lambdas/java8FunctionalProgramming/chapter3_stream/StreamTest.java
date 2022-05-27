package lambdas.java8FunctionalProgramming.chapter3_stream;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class StreamTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        int price = map.computeIfAbsent("t", t -> 3);
        System.out.println(price);
        System.out.println(JSON.toJSONString(map));

//        int price1 = map.computeIfPresent("n", (k, v) -> v + 2);

        int price1 = map.computeIfPresent("1", (k, v) -> v + 22);
        System.out.println(price1);
        System.out.println(JSON.toJSONString(map));
    }
}
