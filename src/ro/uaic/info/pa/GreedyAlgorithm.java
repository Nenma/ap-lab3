package ro.uaic.info.pa;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithm implements Algorithm {
    Knapsack knapsack;
    List<Item> items;

    public GreedyAlgorithm(Knapsack knapsack, List<Item> items) {
        this.knapsack = knapsack;
        this.items = items;
    }

    @Override
    public Knapsack getKnapsack() {
        return knapsack;
    }

    @Override
    public void solve() {
        items.sort(Comparator.comparing(Item::profitFactor));
        Collections.reverse(items);

        int i = 0;
        while (!knapsack.isFull()) {
            if (knapsack.getTotalWeight() + items.get(i).getWeight() <= knapsack.getCapacity()) {
                knapsack.addItem(items.get(i));
            } else {
                break;
            }
            i++;
        }
    }
}
