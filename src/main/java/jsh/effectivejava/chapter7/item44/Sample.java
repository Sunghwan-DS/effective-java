package jsh.effectivejava.chapter7.item44;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

public class Sample {

    public static void main(String[] args) {

        // LinkedHashMap.removeEldestEntry() 확인 용
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        // 정적 팩터리 메서드를 이용한 객체 생성
        List<String> emptyList = Collections.emptyList();
        List<String> singletonList = Collections.singletonList("value");

        BiPredicate<Map,Map.Entry> biPredicate = new BiPredicate<Map, Map.Entry>() {
            @Override
            public boolean test(Map map, Map.Entry entry) {
                return false;
            }
        };
    }
}
