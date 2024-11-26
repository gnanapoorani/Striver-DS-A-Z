package TakeYouForward.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class MinimumNumberOfCoins {


    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int result = coinChange(coins, 11);
        System.out.println(result);
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int count = 0;
        int index = n - 1;
        while (index <= 0) {
            while (coins[index] < amount) {
                amount -= coins[index];
                count++;
            }
            if (amount == 0) {
                break;
            }
            index++;
        }
        return count;
    }
}