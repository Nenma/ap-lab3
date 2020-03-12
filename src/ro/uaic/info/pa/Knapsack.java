package ro.uaic.info.pa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack {
    int capacity;
    List<Item> items;

    public Knapsack(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public Knapsack(int capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotalValue() {
        if (items.isEmpty()) {
            return 0;
        }
        int totalValue = 0;
        for (Item item : items) {
            totalValue += item.getValue();
        }
        return totalValue;
    }

    public int getTotalWeight() {
        if (items.isEmpty()) {
            return 0;
        }

        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public void printStatus() {
        System.out.println("Contents: ");
        for (Item item : items) {
            System.out.print('\t');
            System.out.println(item);
        }
        System.out.println("Total weight: " + getTotalWeight());
        System.out.println("Total value: " + getTotalValue());
        System.out.println("Knapsack capacity: " + getCapacity());
    }

    public boolean isFull() {
        if (items.isEmpty()) {
            return false;
        } else {
            return capacity == getTotalWeight();
        }
    }

    public void addItem(Item item) {
        if (getTotalWeight() + item.getWeight() <= capacity) {
            items.add(item);
        } else {
            System.out.println("Capacity overload!");
        }
    }
}
