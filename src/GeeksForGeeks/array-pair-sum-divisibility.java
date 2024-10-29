package GeeksForGeeks;

import java.util.ArrayList;

class arraypairsumdivisibility {
    public static void main(String[] args) {
//        int[] arr = {11, 6, 7, 13, 13, 6};
        int[] arr = {10,4,2,2};
        System.out.println(canPair(arr, 6));
    }

    public static boolean canPair1(int[] nums, int k) {
        if (nums.length % 2 == 0) {
            ArrayList list = new ArrayList();

            int num;
            for (int i = 0; i < nums.length; i++) {
                int rem = nums[i] % k;

                if (rem != 0) {
                    num = k - rem;
                } else {
                    num = rem;
                }

                if(list.contains(num)){
                    int index=list.indexOf(num);
                    list.remove(index);
                }else{
                    list.add(rem);
                }
            }

            if (list.size() == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean canPair(int[] nums, int k) {
        // Code here
        int n = nums.length;
        if(n%2 ==1 ){
            return false;

        }
        int freq[] = new int[k];
        for (int i : nums) {
            int y = i % k;
            if (freq[(k - y) % k] != 0)
                freq[(k - y) % k]--;
            else
                freq[y]++;
        }
        for (int i : freq) {
            if (i != 0)
                return false;
        }
        return true;

    }
}
