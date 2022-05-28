package lambdas.java8inaction.chap3;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        consumer.accept("t");
    }
}
