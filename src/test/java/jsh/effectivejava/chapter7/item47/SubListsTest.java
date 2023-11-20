package jsh.effectivejava.chapter7.item47;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest
public class SubListsTest {

    @Test
    @DisplayName("SubLists.of() 테스트")
    void subListsOfTest() {

        var subLists = SubLists.of(List.of(1, 2, 3, 4, 5));

        subLists
//            .filter(list -> !CollectionUtils.isEmpty(list))
            .forEach(System.out::println);
    }
}
