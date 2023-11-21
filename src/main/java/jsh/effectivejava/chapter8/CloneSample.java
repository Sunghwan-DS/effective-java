package jsh.effectivejava.chapter8;

public class CloneSample {

    public static void main(String[] args) {

        Malicious malicious = new Malicious();
        ClonePeriod clonePeriod = new ClonePeriod(malicious);
    }
}
