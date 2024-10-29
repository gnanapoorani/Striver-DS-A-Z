package TakeYouForward.Greedy;

import java.util.ArrayList;
import java.util.List;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class InsertIntervals {


    public static void main(String[] args) {
        int intervals[][] = {{1, 3}, {6, 9}};
        int newInterval[] = {2, 5};
        int result[][] = insert(intervals, newInterval);
        System.out.println(result);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int start = newInterval[0];
        int i = 0;
        int[] resultArray = new int[2];
        while (i < intervals.length && intervals[i][1] < start) {
            resultArray = intervals[i];
            result.add(resultArray);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while(i<intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}