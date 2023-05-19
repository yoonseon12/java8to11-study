package study.java8to11.step2.MethodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {

        /** static 메서드 참조 **/
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("java")); // hi java

        /** 특정 객체의 인스턴스 메서드 참조 **/
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hi.apply("java")); // hello java

         /** 입력값이 없는 생성자 메서드 참조 **/
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting newMethodGreeting = newGreeting.get();

         /** 입력값을 있는 생성자 메서드 참조 **/
        Function<String, Greeting> newGreetingWithName = Greeting::new;
        Greeting newMethodParamGreeting = newGreetingWithName.apply("java");

        /**임의 객체의 인스턴스 메서드 참조**/
        String[] names = {"member3", "member2", "member1"};
        // 기존의 익명클래스를 사용한 방법
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        // 람다 사용
        Arrays.sort(names,((o1, o2) -> 0));
        // 메서드 레퍼런스 사용
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));
    }
}
