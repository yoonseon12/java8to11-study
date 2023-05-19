package study.java8to11.step2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class VariableCapture {
    public static void main(String[] args) {
        VariableCapture variableCapture = new VariableCapture();
        variableCapture.run();
    }

    private void run() {
        int baseNumber = 10; // 외부지역변수, effective final variable
        // final int baseNumber = 10; // {1} 이 변수를 다른곳에서 변경하지 않는 경우 자바 8부터 final 생략 가능

        // 내부 클래스에서 외부지역변수 참조
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 20; // 쉐도윙(Shadowing)으로 외부 지역변수를 덮음
                System.out.println("내부 클래스 : "+baseNumber); // 20 {2}
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printBaseNumber();

        // 익명 클래스에서 외부지역변수 참조
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) { // 쉐도윙(Shadowing)으로 외부지역변수를 덮음
                System.out.println("익명 클래스 : "+baseNumber); // 30 {3}
            }
        };
        integerConsumer.accept(30);

        // 람다에서 지역변수 참조
        IntConsumer printInt = (i) -> {
            // int baseNumber = 50; // 변수 선언 불가(쉐도잉 안됨)
            System.out.println("람다 : "+ (i + baseNumber)); // 40 {4}
        };
        printInt.accept(30);

        //baseNumber++; // <<<<<<<<<<<<<<<<< 값 재할당 !!!!
    }
}
