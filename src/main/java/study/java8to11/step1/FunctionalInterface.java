package study.java8to11.step1;

import java.util.function.*;

public class FunctionalInterface {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);// 뒤에오는 함수를 적용 후 결과값을 앞에있는 함수에 입력값으로 사용
        Function<Integer, Integer> integerIntegerFunction = plus10.andThen(multiply2);// 앞에있는 함수 적용 후 결과값을 뒤에 있는 함수에 입력값으로 사용

        System.out.println(multiply2AndPlus10.apply(2)); // 12
        System.out.println(integerIntegerFunction.apply(2)); // 24


        BiFunction<String, Integer, String> biFunction = (s, i) -> "Hello" + s + i;
        System.out.println(biFunction.apply("World",2023)); // HelloWorld2023

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(1); // 1

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get()); // 10

        Predicate<Integer> isEven = (i) -> i%2 == 0;
        Predicate<Integer> isOdd = (i) -> i%2 == 1;
        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(13)); // false
        System.out.println(isOdd.test(13)); // true

        System.out.println(isEven.and(isOdd).test(1)); // && false
        System.out.println(isEven.or(isOdd).test(1));  // || true
        System.out.println(isEven.negate().test(1));   // !  true


        UnaryOperator<Integer> plus20 = (i) -> i + 20;
        System.out.println(plus20.apply(1)); // 21

        BinaryOperator<String> binaryOperator = (s, i) -> "Hello" + s + i;
        System.out.println(binaryOperator.apply("World","2023")); // HelloWorld2023
    }
}
