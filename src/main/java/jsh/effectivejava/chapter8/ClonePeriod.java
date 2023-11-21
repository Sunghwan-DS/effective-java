package jsh.effectivejava.chapter8;

import java.util.Date;

public class ClonePeriod {

    Date data;

    public ClonePeriod(Date date) {
        this.data = (Date)date.clone();
    }
}
