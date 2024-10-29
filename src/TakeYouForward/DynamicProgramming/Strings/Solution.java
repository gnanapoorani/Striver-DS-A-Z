package TakeYouForward.DynamicProgramming.Strings;


import java.util.*;
//
//class itemPurchase {
//    public static void main(String[] args)
//    {
//        List<Integer> price=new ArrayList<>();
//        price.add(2);
//        price.add(4);
//        price.add(6);
//
//        System.out.println(findMinimumPrice(price,3,0,0L));
//    }
//
//    public static long findMinimumPrice(List<Integer> price, int m,int index,long totalPrice) {
//      long answer=0L;
//
//
//    }
//}

interface IProduct {
    String getProductId();

    void setProductId(String productId);

    int getSalesVelocity();

    void setSalesVelocity(int salesVelocity);

    int getStockLevel();

    void setStockLevel(int stockLevel);
}


class Product implements IProduct {
    String productId;
    int salesVelocity;
    int stockLevel;

    public static long findMinimumPrice(List<Integer> prices, int m) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int price : prices) {
            maxHeap.offer(price);
        }
        while (m > 0 && !maxHeap.isEmpty()) {
            int currentPrice = maxHeap.poll();
            int nextItemValue= maxHeap.peek();
            while(currentPrice>=nextItemValue){
                currentPrice= currentPrice / 2;
                m--;
            }
            maxHeap.offer(currentPrice);
        }
        // Calculate the remaining total cost of items
        long totalCost = 0;
        while (!maxHeap.isEmpty()) {
            totalCost += maxHeap.poll();
        }
        return totalCost;
    }
    Product(String productId, int salesVelocity, int stockLevel) {
        this.productId = productId;
        this.salesVelocity = salesVelocity;
        this.stockLevel = stockLevel;
    }

    @Override
    public String getProductId() {
        return this.productId;
    }

    @Override
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public int getSalesVelocity() {
        return this.salesVelocity;
    }

    @Override
    public void setSalesVelocity(int salesVelocity) {
        this.salesVelocity = salesVelocity;
    }

    @Override
    public int getStockLevel() {
        return this.stockLevel;
    }

    @Override
    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
}

class InventoryClearance {
    public static List<String> identifyClearanceItems(List<Product> products) {
        List<String> clearanceItems = new ArrayList<>();
        for(Product item:products){
            int stockValue=item.getStockLevel();
            int salesValue=item.getSalesVelocity();

            if(stockValue >=salesValue *10){
                clearanceItems.add(item.productId);
            }
        }
        return clearanceItems;
    }
}

 class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine().trim());
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] productDetails = scanner.nextLine().trim().split(" ");
            String productId = productDetails[0];
            int salesVelocity = Integer.parseInt(productDetails[1]);
            int stockLevel = Integer.parseInt(productDetails[2]);
            products.add(new Product(productId, salesVelocity, stockLevel));
        }

        List<String> clearanceItems = InventoryClearance.identifyClearanceItems(products);

        clearanceItems.forEach(System.out::println);
    }
}