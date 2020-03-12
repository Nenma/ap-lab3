package ro.uaic.info.pa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lab3 {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(10);

        Item book1 = new Book("Dragon Rising", 300, 5);
        Item book2 = new Book("A Blade in the Dark", 300, 5);
        Item food1 = new Food("Cabbage", 2);
        Item food2 = new Food("Rabbit", 2);
        Item weapon = new Weapon(WeaponType.SWORD, 5, 10);
        List<Item> items = Arrays.asList(book1, book2, food1, food2, weapon);

        knapsack.addItem(weapon);
        knapsack.addItem(book1);
        knapsack.addItem(food1);

        Collections.sort(knapsack.getItems());

        System.out.println("======= Instance described in the example =======");
        knapsack.printStatus();


        Algorithm ga = new GreedyAlgorithm(new Knapsack(10), items);
        ga.solve();
        System.out.println("======= Greedy solution =======");
        ga.getKnapsack().printStatus();

        Algorithm dpa = new DynamicProgrammingAlgorithm(new Knapsack(10), items);
        dpa.solve();
        System.out.println("======= Dynamic Programming solution =======");
        dpa.getKnapsack().printStatus();

        System.out.println("\n\n");

        // Running time difference between the 2 methods
        Algorithm gaTest = new GreedyAlgorithm(new Knapsack(10), generateRandomItemsList());
        long start = System.nanoTime();
        gaTest.solve();
        System.out.println("======= GA =======");
        gaTest.getKnapsack().printStatus();
        long finish = System.nanoTime();
        System.out.println("Running time: " + (finish - start) + "ns");

        System.out.println();

        Algorithm dpaTest = new DynamicProgrammingAlgorithm(new Knapsack(10), generateRandomItemsList());
        start = System.nanoTime();
        dpaTest.solve();
        System.out.println("======= DPA =======");
        dpaTest.getKnapsack().printStatus();
        finish = System.nanoTime();
        System.out.println("Running time: " + (finish - start) + "ns");
    }

    private static List<Item> generateRandomItemsList() {
        List<String> titles = Arrays.asList("Dragon Rising", "A Blade in the Dark", "The Count of Monte Cristo", "Red Rising", "Dunes", "Demon Slayer", "The Picture of Dorian Gray", "Moby Dick", "Harry Potter", "Strange Things");
        List<String> foods = Arrays.asList("Apple", "Pineapple", "Banana", "Cucumber", "Tomato", "Potato", "Melon", "Pear", "Cake", "Pasta");
        List<WeaponType> types = Arrays.asList(WeaponType.SWORD, WeaponType.BOW, WeaponType.LANCE);

        Random random = new Random();

        // Generate 2 random books
        Item book1 = new Book(titles.get(random.nextInt(titles.size() - 1)), (random.nextInt(10) + 1) * 100, random.nextInt(10) + 1);
        Item book2 = new Book(titles.get(random.nextInt(titles.size() - 1)), (random.nextInt(10) + 1) * 100, random.nextInt(10) + 1);

        // Generate 2 random foods
        Item food1 = new Food(foods.get(random.nextInt(foods.size() - 1)), random.nextInt(10) + 1);
        Item food2 = new Food(foods.get(random.nextInt(foods.size() - 1)), random.nextInt(10) + 1);

        // Generate a random weapon
        Item weapon = new Weapon(types.get(random.nextInt(types.size() - 1)), random.nextInt(10) + 1, random.nextInt(10) + 1);

        return Arrays.asList(book1, book2, food1, food2, weapon);
    }
}
