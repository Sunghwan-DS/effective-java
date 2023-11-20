package jsh.effectivejava.chapter6.item34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class MakeSauceTest {

    @Test
    @DisplayName("정수 열거 패턴으로 소스 만들기")
    public void makeSauceWithIntegerEnumerationPatternTest() {

        String sauce = makeSauceWithIntegerEnumerationPattern(IntegerEnumerationPattern.APPLE_FUJI, IntegerEnumerationPattern.ORANGE_TEMPLE, IntegerEnumerationPattern.APPLE_PIPPIN);
        String badSauce = makeSauceWithIntegerEnumerationPattern(IntegerEnumerationPattern.ORANGE_TEMPLE, IntegerEnumerationPattern.APPLE_FUJI, IntegerEnumerationPattern.ORANGE_TEMPLE);

        assertEquals(sauce, "정수 열거 패턴 소스");
        assertNotEquals(badSauce, "정수 열거 패턴 소스");

        // 컴파일하면 그 값이 클라이언트 파일에 그대로 새겨진다?
    }

    private String makeSauceWithIntegerEnumerationPattern(int apple1, int orange, int apple2) {
        return "정수 열거 패턴 소스";
    }

    @Test
    @DisplayName("열거 패턴으로 소스 만들기")
    public void makeSauceWitnEnumTest() {

        String sauce = makeSauceWithEnum(AppleEnum.FUJI, OrangeEnum.TEMPLE, AppleEnum.PIPPIN);

        // 컴파일 에러 발생
        // String badSauce = makeSauceWithEnum(OrangeEnum.TEMPLE, AppleEnum.FUJI, OrangeEnum.TEMPLE);

        assertEquals(sauce, "열거 패턴 소스");
    }

    private String makeSauceWithEnum(AppleEnum apple1, OrangeEnum orange, AppleEnum apple2) {
        return "열거 패턴 소스";
    }
}
