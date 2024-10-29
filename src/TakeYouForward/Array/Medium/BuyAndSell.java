//2147483647 - Int Max value
//-2147483647 - 1 int min value
class BuyAndSell {
    public static void main(String[] args) {
        int[] nums = {7, 2, 3, 4, 6, 1, 4};
        System.out.println(maxProfit(nums));
    }


    public static int maxProfit(int[] prices) {
        int profit = 0, buy = prices[0], sell = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                sell = prices[i];
                int diff = sell - buy;
                if (diff > profit) {
                    profit = diff;
                }
            } else {
                buy = prices[i];
            }
        }
        return profit;

    }
}