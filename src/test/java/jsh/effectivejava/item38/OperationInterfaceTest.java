package jsh.effectivejava.item38;

import jsh.effectivejava.chapter6.item38.ExtendedOperation;
import jsh.effectivejava.chapter6.item38.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

@SpringBootTest
public class OperationInterfaceTest {

    @Test
    @DisplayName("확장된 열거 타입으로 구현된 메서드 테스트")
    void operationTestByExtendedEnumType() {
        double x = 10;
        double y = 2;
        testByExtendedEnumType(ExtendedOperation.class, x, y);
    }

    @Test
    @DisplayName("확장된 열거 타입으로 구현된 메서드 테스트")
    void operationTestByWildCardType() {
        double x = 10;
        double y = 2;
        testByWildCardType(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private <T extends Enum<T> & Operation> void testByExtendedEnumType(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private void testByWildCardType(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
