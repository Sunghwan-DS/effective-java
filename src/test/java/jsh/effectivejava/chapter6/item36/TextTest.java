package jsh.effectivejava.chapter6.item36;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TextTest {

    @Test
    @DisplayName("EnumSet으로 applyStyles 메서드 호출 테스트")
    public void applyStylesTestWithEnumSet() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
        String actualOutput = outputStream.toString();

        assertTrue(actualOutput.contains("Applying Style: BOLD"));
        assertTrue(actualOutput.contains("Applying Style: ITALIC"));
    }

    @Test
    @DisplayName("Set으로 applyStyles 메서드 호출 테스트")
    public void applyStylesTestWithSet() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Text text = new Text();
        text.applyStyles(Set.of(Text.Style.BOLD, Text.Style.ITALIC));
        String actualOutput = outputStream.toString();

        assertTrue(actualOutput.contains("Applying Style: BOLD"));
        assertTrue(actualOutput.contains("Applying Style: ITALIC"));
    }
}
