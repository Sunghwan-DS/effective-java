package jsh.effectivejava.chapter8;

import java.util.Date;

public class Sample {

    public static void main(String[] args) {

        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);

        p.end().setYear(78);
        System.out.println(p.end().getTime());
    }
}
