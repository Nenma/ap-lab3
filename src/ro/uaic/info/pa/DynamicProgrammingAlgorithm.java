package ro.uaic.info.pa;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class DynamicProgrammingAlgorithm implements Algorithm {
    Knapsack knapsack;
    List<Item> items;

    public DynamicProgrammingAlgorithm(Knapsack knapsack, List<Item> items) {
        this.knapsack = knapsack;
        this.items = items;
    }

    @Override
    public Knapsack getKnapsack() {
        return knapsack;
    }

    // Implementation taken from Guru99: https://www.guru99.com/knapsack-problem-dynamic-programming.html
    @Override
    public void solve() {
        // lists for item weights and values
        List<Integer> weights = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (Item item : items) {
            weights.add(item.getWeight());
            values.add(item.getValue());
        }

        // matrix initialization
        int n = items.size();
        int m = knapsack.getCapacity();
        int[][] value = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                value[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                value[i][j] = value[i - 1][j];
                if ((j >= weights.get(i - 1)) && (value[i][j] < value[i - 1][j - weights.get(i - 1)] + values.get(i - 1))) {
                    value[i][j] = value[i - 1][j - weights.get(i - 1)] + values.get(i - 1);
                }
            }
        }

        while (n != 0) {
            if (value[n][m] != value[n - 1][m]) {
                knapsack.addItem(items.get(n - 1));
                m = m - weights.get(n - 1);
            }
            n--;
        }
    }
}
