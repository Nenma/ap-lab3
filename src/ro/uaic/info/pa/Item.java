package ro.uaic.info.pa;

public interface Item extends Comparable<Item> {
    String getName();
    int getWeight();
    int getValue();

    default double profitFactor() {
        return (double)getValue() / getWeight();
    }

    @Override
    default int compareTo(Item o) {
        return getName().compareTo(o.getName());
    }
}
