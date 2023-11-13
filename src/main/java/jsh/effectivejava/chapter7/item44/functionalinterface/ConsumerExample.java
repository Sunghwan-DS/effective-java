package jsh.effectivejava.chapter7.item44.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        // 각 요소를 출력하는 Consumer 정의
        Consumer<Integer> printElement = element -> System.out.print(element + " ");

        // 리스트의 각 요소를 출력
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(printElement);

        // 또는 람다 표현식을 직접 사용하여 출력
        System.out.println("\nUsing lambda expression:");
        numbers.forEach(element -> System.out.print(element + " "));
    }
}

