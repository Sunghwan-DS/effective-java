package jsh.effectivejava.chapter6.item34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class OperationTest {

    @Test
    @DisplayName("Operation valueOf method test")
    public void valueOfTest() {

        Operation plusOperation = Operation.valueOf("PLUS");
        Operation minusOperation = Operation.valueOf("MINUS");
        Operation timesOperation = Operation.valueOf("TIMES");
        Operation divideOperation = Operation.valueOf("DIVIDE");

        assertEquals(plusOperation, Operation.PLUS);
        assertEquals(minusOperation, Operation.MINUS);
        assertEquals(timesOperation, Operation.TIMES);
        assertEquals(divideOperation, Operation.DIVIDE);
    }

    @Test
    @DisplayName("Operation fromString method test")
    public void fromStringTest() {

        Operation plusOperation = Operation.fromString("+").get();
        Operation minusOperation = Operation.fromString("-").get();
        Operation timesOperation = Operation.fromString("*").get();
        Operation divideOperation = Operation.fromString("/").get();

        assertEquals(plusOperation, Operation.PLUS);
        assertEquals(minusOperation, Operation.MINUS);
        assertEquals(timesOperation, Operation.TIMES);
        assertEquals(divideOperation, Operation.DIVIDE);
    }

    @Test
    @DisplayName("Operation fromString method null test")
    public void fromStringNullTest() {

        boolean isPresent = Operation.fromString("X").isPresent();

        assertFalse(isPresent);
    }
}
