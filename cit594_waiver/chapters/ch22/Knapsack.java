package cit594_waiver.chapters.ch22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    public double weight;
    public double value;

    Item(double itemWeight, double itemValue) {
        weight = itemWeight;
        value = itemValue;
    }
}

class ItemValueComparator implements Comparator<Item> {
    public int compare(Item item1, Item item2) {
        if (item1.value < item2.value) {
            return 1;
        }
        else if (item1.value > item2.value) {
            return -1;
        }
        return 0;
    }
}

public class Knapsack {
    private double maxWeight;
    private ArrayList<Item> items;

    Knapsack(double maximumWeight) {
        maxWeight = maximumWeight;
        items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public static Knapsack knapsack01(Item[] availableItems, double maxWeight) {
        // Sort the items in descending order based on value
        Arrays.sort(availableItems, new ItemValueComparator());

        // Initialize a new knapsack to hold items
        Knapsack knapsack = new Knapsack(maxWeight);

        double remaining = maxWeight;
        for (Item item : availableItems) {
            if (item.weight <= remaining) {
                knapsack.getItems().add(item);
                remaining -= item.weight;
            }
        }

        return knapsack;
    }

    // 기본값 없이 호출되는 메서드
    public double exponentialOptimal(Item[] availableItems, double maxWeight) {
        // 기본값을 제공하고 재귀를 시작
        return exponentialOptimal(availableItems, maxWeight, 0, 0, 0);
    }

    // 내부적으로 호출되는 메서드
    public double exponentialOptimal(Item[] availableItems, double maxWeight, int i, double currWeight, double currValue) {
        // 경계 조건: 배열 끝에 도달하거나 무게가 초과된 경우
        if (i >= availableItems.length || currWeight > maxWeight) {
            return currValue;
        }

        // 현재 아이템을 포함한 경우
        double includedValue = 0;
        if (currWeight + availableItems[i].weight <= maxWeight) {
            includedValue = exponentialOptimal(
                availableItems,
                maxWeight,
                i + 1,
                currWeight + availableItems[i].weight,
                currValue + availableItems[i].value
            );
        }

        // 현재 아이템을 포함하지 않은 경우
        double excludedValue = exponentialOptimal(availableItems, maxWeight, i + 1, currWeight, currValue);

        // 둘 중 최댓값 반환
        return Math.max(includedValue, excludedValue);
    }

    public static void main(String[] args) {
        // Create an array of available items
        Item[] availableItems = {
                new Item(6.0, 25.0),
                new Item(8.0, 42.0),
                new Item(12.0, 60.0),
                new Item(18.0, 95.0)
        };

        // Prompt for the knapsack's maximum weight
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter maximum weight the knapsack can hold: ");
        double maxWeight = scnr.nextDouble();

        Knapsack knapsack = Knapsack.knapsack01(availableItems, maxWeight);

        // Show the objects in the knapsack
        System.out.println();
        System.out.println("Objects in knapsack:");
        int i = 1;
        double sumWeight = 0.0;
        double sumValue = 0.0;
        for (Item item : knapsack.getItems()) {
            sumWeight += item.weight;
            sumValue += item.value;
            System.out.printf("%d: weight %d, value %d%n", i, (int)item.weight,
                    (int)item.value);
            i++;
        }
        System.out.println();

        System.out.printf("Total weight of items in knapsack: %d%n", (int) sumWeight);
        System.out.printf("Total value of items in knapsack: %d%n", (int) sumValue);

        System.out.printf("Recursive Optimal: %.0f%n", knapsack.exponentialOptimal(availableItems, maxWeight));
    }
}



