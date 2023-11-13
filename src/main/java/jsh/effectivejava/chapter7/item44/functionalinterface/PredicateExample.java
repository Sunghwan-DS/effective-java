package jsh.effectivejava.chapter7.item44.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        // 조건을 검사하는 Predicate 정의 (짝수 여부를 검사)
        Predicate<Integer> isEven = num -> num % 2 == 0;
        // 기본 인터페이스
        IntPredicate isOdd = num -> num % 2 == 1;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // Predicate를 사용하여 짝수만 필터링
        numbers.removeIf(isEven);

        // 결과 출력
        System.out.println("Filtered numbers (odd): " + numbers);
        System.out.println("Is 5 Odd? : " + isOdd.test(5));
    }
}
