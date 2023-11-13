package jsh.effectivejava.chapter7.item44.functionalinterface;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        // 랜덤한 정수를 생성하는 Supplier 정의
        Supplier<Integer> randomIntegerSupplier = () -> new Random().nextInt(100);

        // Supplier를 사용하여 랜덤한 정수 생성
        int randomValue = randomIntegerSupplier.get();

        // 결과 출력
        System.out.println("Random Integer: " + randomValue);
    }
}
