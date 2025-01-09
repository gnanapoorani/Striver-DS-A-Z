package Java.FunctionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class FIExampleClient {
    public static void main(String[] args) {

        Operation add = (a, b) -> a + b;
        Operation multiply = (a, b) -> a * b;

        System.out.println("addition " + add.operate(2, 3));
        System.out.println("multiply " + multiply.operate(2, 3));

        /**
         * Built in Funcitonal interface
         */
        Predicate<Integer> isEven = (a) -> a % 2 == 0;
        Predicate<Integer> isEven1 = (a) -> a % 3 == 0;

        Predicate<Integer> value = isEven.and(isEven1);



        System.out.println("predicate is Even test for 2 " + isEven.test(2));
        System.out.println("predicate is Even test for 6 " + value.test(6));

        Function<String, String> before = str -> str.replace('l','i');
        Function<String, Integer> length = str -> str.indexOf("i");

        System.out.println("index of string i"+length.apply("Hello"));
        System.out.println(("index of string i"+length.compose(before).apply("Hello")));



        Consumer<String> print = str -> System.out.println("Value: " + str);

        print.accept("Functional Interface Example");

        Supplier<Double> randomValue = () -> Math.random();

        System.out.println("Random Value: " + randomValue.get());


    }
}