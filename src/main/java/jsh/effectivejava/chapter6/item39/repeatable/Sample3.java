package jsh.effectivejava.chapter6.item39.repeatable;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {

    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() {

        List<String> list = new ArrayList<>();

        list.addAll(5, null);
    }
}
