package jsh.effectivejava.item37;

import jsh.effectivejava.chapter6.item37.Plant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class PlantTest {

    private static final List<Plant> garden = List.of(new Plant("a", Plant.LifeCycle.ANNUAL), new Plant("b", Plant.LifeCycle.BIENNIAL), new Plant("c", Plant.LifeCycle.PERENNIAL), new Plant("d", Plant.LifeCycle.ANNUAL));

    @Test
    @DisplayName("ordinal()을 배열 인덱스로 사용 - 따라 하지 말 것!")
    public void plantTest() {
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        for (Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        // 결과 출력
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    @Test
    @DisplayName("EnumMap을 사용해 데이터와 열거 타입을 매핑한다.")
    public void plantTest2() {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        System.out.println(plantsByLifeCycle);

    }
}
