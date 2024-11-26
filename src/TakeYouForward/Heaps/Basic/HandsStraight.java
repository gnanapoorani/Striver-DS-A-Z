package TakeYouForward.Heaps.Basic;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class HandsStraight {

    public static void main(String[] args) {
        int a[] = {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
        int groupSize = 3;
        System.out.print(groupSize + " Hands straight");
        System.out.println(isNStraightHand(a, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int W) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : hand) {
            minHeap.add(i);
        }
        while (minHeap.size() != 0) {
            int start = minHeap.poll();
            for (int j = 1; j < W; j++) {
                if (minHeap.remove(start + j)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    remove operation is linear time. Not efficient in java.
     */
    public boolean isNStraightHandUsingTreeMap(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : hand) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        while (!treeMap.isEmpty()) {
            int first = treeMap.firstKey();
            for (int j = 1; j < W; j++) {
                int next = first + j;
                if (treeMap.containsKey(next)) {
                    treeMap.put(next, treeMap.get(next) - 1);
                    if (treeMap.get(next) == 0) treeMap.remove(next);
                } else {
                    return false;
                }
            }
            treeMap.put(first, treeMap.get(first) - 1);
            if (treeMap.get(first) == 0) treeMap.remove(first);
        }
        return true;
    }
}
