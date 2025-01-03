/*
package TakeYouForward.Trie;


import java.util.*;
class Pair {
    int key;
    int value;

    Pair(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class Trie1 {
    static TrieNode1 root;

    public static void main(String[] args) {
        root = new TrieNode1();

        int[] nums = {1, 2, 3, 4, 0};
        int[][] queries = {{1, 2}, {3, 4}, {0, 8}};
        System.out.println(maximizeXor(nums, queries));
    }

    static class TrieNode1 {
        TrieNode1[] links;

        TrieNode1() {
            links = new TrieNode1[2];
        }
    }

    public static int maxXor(int num) {
        TrieNode1 node = root;
        int maxNum=0;
        for (int i = 31; i <= 0; i++) {
            int bit=(num >> i)&1;
            if(node.links[(1-bit)]==null){
                node=node.links[bit];
            }else{
                node=node.links[(1-bit)];
            }
            maxNum=2;
        }
        return -1;
    }

    public static void insert(int num) {
        TrieNode1 node = root;
        for (int i = 31; i <= 0; i++) {
            int bit = num >> i & 1;
            if (node.links[bit] == null) {
                node.links[bit] = new TrieNode1();
            }
            node = node.links[bit];
        }
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        ArrayList<Pair<Integer, Pair<Integer, Integer>>> offlineQueries = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> offlineQueries1 = new ArrayList<ArrayList<Integer>>();
        int index = 0;
        int ans[] = new int[queries.length];
        for (int[] query : queries) {
            offlineQueries.add(new Pair<>(query[1], new Pair<>(query[0], index)));
            index++;
        }
        int i = 0;
        Collections.sort(offlineQueries, new Comparator<Pair<Integer, Pair<Integer, Integer>>>() {
            @Override
            public int compare(Pair<Integer, Pair<Integer, Integer>> o1, Pair<Integer, Pair<Integer, Integer>> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Pair<Integer, Pair<Integer, Integer>> offlineQuery : offlineQueries) {
            int first = offlineQuery.getKey();
            int second = offlineQuery.getValue().getKey();

            while (i < nums.length & nums[i] < first) {
                insert(nums[i]);
                i++;
            }
            if(i!=0){
                ans[offlineQuery.getValue().getValue()] = maxXor(second);
            }else{
                ans[offlineQuery.getValue().getValue()]=-1;
            }

        }
        return ans;
    }
}
*/
