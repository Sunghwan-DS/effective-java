package jsh.effectivejava.chapter7.item47;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PowerSet {

    public static void main(String[] args) {

        System.gc();
        Set<Integer> numberSet = IntStream.rangeClosed(1, 15)
                                          .boxed()
                                          .collect(Collectors.toSet());

        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        var powerSetByAbstractList = (AbstractList<Set<Integer>>) PowerSet.of(numberSet);
        var sample = powerSetByAbstractList.get(100);
        System.out.println("sample: " + sample);

        long abstractListMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        var powerSetByHashSet = getPowerSet(numberSet);

        long hashSetMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("PowerSet By AbstractList Memory(MB): " + (abstractListMemory - before) / 1024 / 1024);
        System.out.println("PowerSet By HashSet Memory(MB): " + (hashSetMemory - abstractListMemory) / 1024 / 1024);

    }

    public static final <E> Collection<Set<E>> of(Set<E> s) {

        List<E> src = new ArrayList<>(s);
        if (src.size() > 30) {
            throw new IllegalArgumentException("집합에 원소가 너무 많습니다(최대 30개).: " + s);
        }

        return new AbstractList<Set<E>>() {
            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        result.add(src.get(i));
                    }
                }
                return result;
            }

            @Override
            public int size() {
                // 멱집합의 크기는 2를 원래 집합의 원소 수만큼 거듭제곱한 것과 같다.
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set)o);
            }
        };
    }

    public static <E> Set<Set<E>> getPowerSet(Set<E> originalSet) {
        Set<Set<E>> powerSet = new HashSet<>();
        powerSet.add(new HashSet<>());

        for (E element : originalSet) {
            Set<Set<E>> newSubsets = new HashSet<>();
            for (Set<E> subset : powerSet) {
                Set<E> newSubset = new HashSet<>(subset);
                newSubset.add(element);
                newSubsets.add(newSubset);
            }
            powerSet.addAll(newSubsets);
        }

        return powerSet;
    }
}
