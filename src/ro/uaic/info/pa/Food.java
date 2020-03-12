package ro.uaic.info.pa;

public class Food implements Item {
    String name;
    int weight;
    int value;

    public Food(String name, int weight) {
        this.name = name;
        this.weight = weight;
        value = weight * 2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
        value = weight * 2;
    }

    public void setValue(int value) {
        this.value = value;
        weight = value / 2;
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
        return "[Food] " + name + " W:" + getWeight() + " V:" + getValue();
    }
}
