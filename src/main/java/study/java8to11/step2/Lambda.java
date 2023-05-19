package study.java8to11.step2;

import java.util.function.*;

public class Lambda {
    public static void main(String[] args) {

        /**** 인자리스트 예시 *****/
        // 인자가 없을 때 : 인자리스트 괄호() 필수
        Supplier<Integer> get10 = () -> 10;

        // 인자가 하나일 경우 : 인자리스트 괄호() 생략 가능
        UnaryOperator<Integer> plus10 = s -> s + 10;

        // 인자가 여러개일 경우 : 인자리스트()괄호 생략 불가능
        BinaryOperator<Integer> sum1 = (a, b) -> a + b;

        // 인자타입은 생략 가능하지만 파라미터 타입을 명시 가능.
        BinaryOperator<Integer> sum2 = (Integer a, Integer b) -> a + b;
        BinaryOperator<Integer> sum3 = (a,  b) -> a + b;


        /** 바디 예시 **/
        // 바디가 한 줄일 경우 바디 괄호{} 생략가능
        Consumer<String> print1 = (s) -> System.out.println("첫 번째 줄");
        Consumer<String> print2 = (s) -> {
            System.out.println(s + "첫 번째 줄");
            System.out.println(s + "두 번째 줄");
        };
    }
}