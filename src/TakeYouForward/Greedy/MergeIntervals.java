package TakeYouForward.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class MergeIntervals {


    public static void main(String[] args) {
        int intervals[][] = {{1, 3}, {6, 9}};
        int result[][] = merge(intervals);
        System.out.println(result);
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1]=Math.max(interval[1],newInterval[1]);
            }else{
                newInterval=interval;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}