package jsh.effectivejava.chapter7.item48;

import java.util.Arrays;
import java.util.List;

public class ReduceSample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Integer test_1 = numbers.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum);
        System.out.println("Test 1: " + test_1);

        Integer test_2 = numbers.parallelStream().reduce(1, (a, b) -> a + b, Integer::sum);
        System.out.println("Test 2: " + test_2);

        Integer test_3 = numbers.parallelStream().reduce(0, (a, b) -> a + b * b, Integer::sum);
        System.out.println("Test 3: " + test_3);

        Integer test_4 = numbers.parallelStream().reduce(0, (a, b) -> a * a + b * b, Integer::sum);
        System.out.println("Test 4: " + test_4);

        Integer test_5 = numbers.parallelStream().reduce(2, (a, b) -> a + b * b, Integer::sum);
        System.out.println("Test 5: " + test_5);

        Integer test_6 = numbers.parallelStream().reduce(2, (a, b) -> a * a + b * b, Integer::sum);
        System.out.println("Test 6: " + test_6);

        Integer test_7 = numbers.parallelStream().reduce(1, (a, b) -> a * b, (a, b) -> a * b);
        System.out.println("Test 7: " + test_7);
    }
}
