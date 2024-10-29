package TakeYouForward.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class NonOverlappingIntervals {


    public static void main(String[] args) {
        int intervals[][] = {{1,2},{2,3},{3,4},{1,3}};
        int result = eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        int remove=0;
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] == newInterval[0] || interval[0] < newInterval[1]) {
                newInterval[1]=Math.min(interval[1],newInterval[1]);
            }else{
                newInterval=interval;
                result.add(interval);
            }
        }
        return intervals.length-result.size();

    }
}