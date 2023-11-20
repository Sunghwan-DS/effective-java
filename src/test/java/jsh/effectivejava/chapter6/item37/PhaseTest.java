package jsh.effectivejava.chapter6.item37;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PhaseTest {

    @Test
    @DisplayName("상전이 맵 테스트 - From SOLID To LIQUID = MELT")
    void transitionMapTest() {

        assertEquals(Phase.Transition.from(Phase.SOLID, Phase.LIQUID), Phase.Transition.MELT);
    }
}
