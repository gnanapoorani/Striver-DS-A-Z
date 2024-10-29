package TakeYouForward.Greedy;

import jdk.internal.org.objectweb.asm.tree.analysis.BasicValue;

import java.util.Arrays;
import java.util.Comparator;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class ShortestJobFirst {


    public static void main(String[] args) {
        int arr[] = {4, 3, 7, 1, 2};
        int result = solve(arr);
        System.out.println(result);
    }

    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int n=bt.length;
        int waiting_time = 0;
        int average=0;
        for(int i=1;i<n;i++){
            waiting_time+=bt[i-1];
            average=average+waiting_time;
        }
        return average/n;

    }
}