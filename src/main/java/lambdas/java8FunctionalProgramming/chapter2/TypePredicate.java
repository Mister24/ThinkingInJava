package lambdas.java8FunctionalProgramming.chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class TypePredicate implements Predicate {
    public static void main(String[] args) {
        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
        Map<String, Integer> diamondWordCounts = new HashMap<>();

        Predicate<Integer> integerPredicate = x -> x > 5;
        System.out.println(integerPredicate.test(6));
        System.out.println(integerPredicate.test(3));
    }

    @Override
    public boolean test(Object o) {
        return false;
    }

    @Override
    public Predicate and(Predicate other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate or(Predicate other) {
        return Predicate.super.or(other);
    }
}
