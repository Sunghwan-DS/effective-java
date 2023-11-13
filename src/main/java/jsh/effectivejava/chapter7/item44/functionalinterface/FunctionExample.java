package jsh.effectivejava.chapter7.item44.functionalinterface;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

        // 문자열을 정수로 변환하는 Function 정의
        Function<String, Integer> stringToInteger = Integer::parseInt;

        // 문자열을 정수로 변환
        String strNumber = "123";
        Integer result = stringToInteger.apply(strNumber);

        // 결과 출력
        System.out.println("Converted Integer: " + result);
        System.out.println("Result Class: " + result.getClass());
    }
}
