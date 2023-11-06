package jsh.effectivejava.chapter6.item40;

import java.util.HashSet;
import java.util.Set;

public class Bigram {

    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    // 아이템 10 | equals는 일반 규약을 지켜 재정의하라
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Bigram b = (Bigram) obj;
        return b.first == this.first && b.second == this.second;
    }

    // 아이템 11 | equals를 재정의하려거든 hashCode도 재정의하라
    // 위반 시 hashCode 일반 규약을 어기게 되어 해당 클래스의 인스턴스를 HashMap이나 HashSet 같은 컬렉션의 원소로 사용할 때 문제를 일으킨다.
    @Override
    public int hashCode() {
        return 31 * this.first + this.second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        System.out.println(s.size());
    }
}
