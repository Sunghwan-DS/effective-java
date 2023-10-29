package jsh.effectivejava.chapter6.item36;

import java.util.EnumSet;
import java.util.Set;

public class ImmutableEnumSet<T extends Enum<T>> {
    private final EnumSet<T> enumSet;

    public ImmutableEnumSet(Set<T> set) {
        this.enumSet = EnumSet.copyOf(set);
    }

    public EnumSet<T> getEnumSet() {
        return enumSet.clone();
    }
}
