package jsh.effectivejava.chapter6.item35;

public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8), NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;
    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    /*
    // ordinal 메서드는 열거 상수를 사용하여 빠르고 효율적으로 데이터를 저장하고 관리하는 열거타입 기반 자료구조 EnumSet, EnumMap에 쓰인다.
    // 대부분의 프로그래머는 이 메서드를 쓸 일이 없다.
    public int numberOfMusicians() {
        return ordinal() + 1;
    }
     */

    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}
