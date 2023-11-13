package jsh.effectivejava.chapter7.item44.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String[] args) {

        // 입력값과 출력값이 Integer 타입인 UnaryOperator 정의
        UnaryOperator<Integer> square = x -> x * x;

        // 리스트의 각 요소에 UnaryOperator를 적용하여 제곱 연산 수행
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.replaceAll(square);

        // 결과 출력
        System.out.println("Squared numbers: " + numbers);
    }
}
