package TakeYouForward.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
class FruitsIntoBasket {

    public static void main(String[] args) {
        int[] fruits = {0, 1,0, 2, 1, 1, 2};
        System.out.println((totalFruit(fruits)));
    }

    public static int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }

    public int totalFruit1(int[] tree) {
        int begin = 0, end = 0, type = 0, len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < tree.length) {
            int in = tree[end++]; // new character gets in from string right.
            if (map.getOrDefault(in, 0) == 0) type++;
            map.put(in, map.getOrDefault(in, 0) + 1);
            while (type > 2) {
                int out = tree[begin++]; // old character gets out from string left.
                if (map.put(out, map.get(out) - 1) == 1) type--;
            }
            len = Math.max(len, end - begin);
        }
        return len;
    }

}