package jsh.effectivejava.item36;

import jsh.effectivejava.chapter6.item36.DayEnum;
import jsh.effectivejava.chapter6.item36.ImmutableEnumSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.EnumSet;
import java.util.Set;

@SpringBootTest
public class ImmutableEnumTest {

    @Test
    @DisplayName("가변 EnumSet 테스트")
    public void mutableEnumSetTest() {
        EnumSet<DayEnum> weekendEnumSet = EnumSet.of(DayEnum.SATURDAY, DayEnum.SUNDAY);
        weekendEnumSet.add(DayEnum.MONDAY);

        Assertions.assertTrue(weekendEnumSet.contains(DayEnum.MONDAY));
    }

    @Test
    @DisplayName("불변 EnumSet 테스트")
    public void immutableEnumSetTest() {

        ImmutableEnumSet<DayEnum> weekendEnumSet = new ImmutableEnumSet<>(Set.of(DayEnum.SATURDAY, DayEnum.SUNDAY));
        weekendEnumSet.getEnumSet().add(DayEnum.MONDAY);

        Assertions.assertTrue(weekendEnumSet.getEnumSet() instanceof EnumSet<?>);
        Assertions.assertFalse(weekendEnumSet.getEnumSet().contains(DayEnum.MONDAY));
    }
}
