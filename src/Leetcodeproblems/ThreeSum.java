import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public static void main(String[] args) {

        String a="20.90";
        System.out.println(Double.valueOf(a)*100);
        int arr[] = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(arr);
        int splitPos = splitTwo(arr);

        if (splitPos > 0) {
            int negArr[] = Arrays.copyOfRange(arr, 0, splitPos);
            int posArr[] = Arrays.copyOfRange(arr,splitPos, arr.length );
            threeSum(negArr, posArr);
        }
    }

    public static void threeSum(int[] neg, int[] pos) {
        List<List<Integer>> output = new ArrayList<>();

        int res = 0;
        int k = pos.length-1;
        for (int i = 0, j = i + 1; j < neg.length; i++,j++) {
            res = neg[i] + neg[j];
                while (k>=0 && pos[k] >= Math.abs(res)) {
                    if (Math.abs(res) == pos[k]) {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(neg[i]);
                        list1.add(neg[j]);
                        list1.add(pos[k]);
                        output.add(list1);
                    }
                    k--;
                }
        }
        k=neg.length-1;
        for (int i = 0, j = i + 1; j < pos.length; i++,j++) {
            res = pos[i] + pos[j];
            while (k>=0 && Math.abs(neg[k]) <= res) {
                if (res == Math.abs(neg[k])) {
                    List<Integer> list2 = new ArrayList<>();
                    list2.add(pos[i]);
                    list2.add(pos[j]);
                    list2.add(neg[k]);
                    output.add(list2);
                }
                k--;
            }
        }
    }
    public static int splitTwo(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                return i;
            }
        }
        return 0;
    }

}