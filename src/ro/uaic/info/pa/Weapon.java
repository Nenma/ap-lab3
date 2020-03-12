package ro.uaic.info.pa;

public class Weapon implements Item {
    String name;
    int weight;
    int value;
    WeaponType type;

    public Weapon(WeaponType type, int weight, int value) {
        this.type = type;
        name = type.name().toLowerCase().substring(0, 1).toUpperCase() + type.name().toLowerCase().substring(1); // SWORD -> sword -> Sword
        this.weight = weight;
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setType(WeaponType type) {
        this.type = type;
        name = type.name().toLowerCase().substring(0, 1).toUpperCase() + type.name().toLowerCase().substring(1);
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
        return "[Weapon] " + name + " W:" + getWeight() + " V:" + getValue();
    }
}
