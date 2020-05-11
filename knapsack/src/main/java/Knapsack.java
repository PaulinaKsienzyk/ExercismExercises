import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Knapsack {

    public int maximumValue(int W, ArrayList<Item> items) {
        if (items.size() <= 0 || W <= 0) {
            return 0;
        }

        int n = items.size();
        int[] w = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < items.size(); i++) {
            w[i] = items.get(i).getWeight();
        }
        for (int i = 0; i < items.size(); i++) {
            v[i] = items.get(i).getValue();
        }


        int[][] m = new int[n + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        return m[n][W];
    }

    public int maxValue(int limit, ArrayList<Item> items) {
        if(items == null || items.size() == 0) {
            return 0;
        }

        // sort elements in descending order by comparing value-weight of the item
        ArrayList<Item> arr1 = new ArrayList<>(items);
        Collections.sort(arr1);
        Collections.reverse(arr1);
        // first solution - knapsack with items sorted in that way
        int val1 = addToKnapsack(arr1, limit);

        // second solution - knapsack with the highest value
        ArrayList<Item> arr2 = bubbleSort(items);
        int val2 = addToKnapsack(arr2, limit);

        // return knapsack with higher value
        return Math.max(val1, val2);
    }

    private int addToKnapsack(ArrayList<Item> items, int limit) {
        int value = 0;
        int weight = 0;
        for (Item item : items) {
            if (item.getWeight() + weight <= limit) {
                value += item.getValue();
                weight += item.getWeight();
            }
        }
        return value;
    }

    private ArrayList<Item> bubbleSort(ArrayList<Item> arrayList) {
        Item[] array = new Item[arrayList.size()];
        for (int i=0; i<array.length; i++) {
            array[i] = arrayList.get(i);
        }

        int n;
        do {
            n = 0;
            for (int i = 0; i< array.length-1; i++) {
                if(array[i+1].getValue() > array[i].getValue()) {
                    Item temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    n = 1;
                }
            }
        } while (n > 0);

        return new ArrayList<>(Arrays.asList(array));
    }



    public static class Item implements Comparator<Item>, Comparable<Item> {
        private final int weight;
        private final int value;
        private final double quotient;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.quotient = (double) value / weight;
        }

        @Override
        public int compare(Item item, Item t1) {
            return (int) (t1.getQuotient() - item.getQuotient());
        }

        @Override
        public int compareTo(Item item) {
            return Double.compare(this.quotient, item.quotient);
        }

        @Override
        public String toString() {
            return Integer.toString(this.value);
        }

        int getWeight() {
            return weight;
        }

        int getValue() {
            return value;
        }

        double getQuotient() {
            return quotient;
        }
    }
    


}