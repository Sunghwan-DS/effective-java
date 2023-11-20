package jsh.effectivejava.chapter7.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class PiSample {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        System.out.println("pi: " + pi(10_000_000L));
        long piTime = System.currentTimeMillis();

        System.out.println("parallelPi: " + parallelPi(10_000_000L));
        long parallelTime = System.currentTimeMillis();

        System.out.println("pi: " + Long.toString(piTime - startTime)); // 23682
        System.out.println("parallelPi: " + Long.toString(parallelTime - piTime)); // 4051
    }

    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                         .mapToObj(BigInteger::valueOf)
                         .filter(i -> i.isProbablePrime(50))
                         .count();
    }

    static long parallelPi(long n) {
        return LongStream.rangeClosed(2, n)
                         .parallel()
                         .mapToObj(BigInteger::valueOf)
                         .filter(i -> i.isProbablePrime(50))
                         .count();
    }
}
