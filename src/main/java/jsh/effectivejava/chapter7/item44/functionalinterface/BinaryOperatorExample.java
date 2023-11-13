package jsh.effectivejava.chapter7.item44.functionalinterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {

        // 입력값과 출력값이 Integer 타입인 BinaryOperator 정의
        BinaryOperator<Integer> add = (x, y) -> x + y;

        // BinaryOperator를 사용하여 덧셈 연산 수행
        int result = add.apply(5, 3);

        // 결과 출력
        System.out.println("Addition result: " + result);
    }
}
