package jsh.effectivejava.chapter6.item36;

import java.util.EnumSet;
import java.util.Set;

public class Text {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH;
    }

    // 어떤 Set을 넘겨도 되나, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) {
        EnumSet<Style> styleSet = EnumSet.noneOf(Style.class); // 빈 EnumSet 생성
        styleSet.addAll(styles);

        styleSet.forEach(style -> System.out.println("Applying Style: " + style));
    }
}
