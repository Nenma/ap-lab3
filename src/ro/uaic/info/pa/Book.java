package ro.uaic.info.pa;

public class Book implements Item {
    String name;
    int weight;
    int value;
    int numberOfPages;

    public Book(String name, int numberOfPages, int value) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.value = value;
        weight = numberOfPages / 100;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
        numberOfPages = weight * 100;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        weight = numberOfPages / 100;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "[Book] " + name + " W:" + getWeight() + " V:" + getValue();
    }
}
