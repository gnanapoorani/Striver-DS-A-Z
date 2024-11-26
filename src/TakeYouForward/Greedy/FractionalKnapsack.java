package TakeYouForward.Greedy;

import java.util.Arrays;
import java.util.Comparator;

import static TakeYouForward.Greedy.FractionalKnapsack.Item;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class FractionalKnapsack {

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    static class ItemComparator implements Comparator<Item> {

        @Override
        public int compare(Item a, Item b) {
            double r1 = (double)(a.value) / (double)(a.weight);
            double r2 = (double)(b.value) / (double)(b.weight);
            if(r1 < r2) return 1;
            else if(r1 > r2) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Item item1 = new Item(60, 10);
        Item item2 = new Item(100, 20);
        Item item3 = new Item(120, 30);
        Item item4 = new Item(200, 40);

        Item[] coins = {item1, item2, item3, item4};
        System.out.println(fractionalKnapsack(70, coins, 11));
    }

    static double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator());
        Arrays.sort(arr, (a,b) ->Integer.compare(b.value/b.weight, a.value/a.weight));
        Arrays.sort(arr, (a,b) ->Double.compare((double)b.value/b.weight, (double)a.value/a.weight));
        int curWeight = 0;
        double curValue = 0;
        for (Item item : arr) {
            if (curWeight+item.weight <= w) {
                curWeight += item.weight;
                curValue += item.value;
            } else {
                int remainingWeight=w-curWeight;
                double value = (item.value * remainingWeight) / item.weight;
                curValue += value;
                return curValue;
            }
            if (curWeight == w) {
                return curValue;
            }
        }
        return curValue;
    }
}