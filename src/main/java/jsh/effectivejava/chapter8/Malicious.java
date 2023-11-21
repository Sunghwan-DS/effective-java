package jsh.effectivejava.chapter8;

import java.util.Date;

public class Malicious extends Date {

    @Override
    public Date clone() {
        System.out.println("해킹");
        return new Malicious();
    }
}
