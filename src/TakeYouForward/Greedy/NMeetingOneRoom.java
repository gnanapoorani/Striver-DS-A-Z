package TakeYouForward.Greedy;

import java.util.Arrays;
import java.util.Comparator;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class NMeetingOneRoom {

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5}, end[] = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end, 6));
    }
    static class meeting {
        int start;
        int end;
        meeting(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] schedule = new int[n][2];

        for (int i = 0; i < n; i++) {
            schedule[i][0] = start[i];
            schedule[i][1] = end[i];
        }
//        Arrays.sort(schedule,Comparator.comparingInt(a->a[0]));
        Arrays.sort(schedule, (a, b) -> a[1] - b[1]);
        int result = 1;
        int endTime = schedule[0][1];
        for (int i = 0; i < n; i++) {
            if (schedule[i][0] > endTime) {
                result++;
                endTime = schedule[i][1];
            }
        }
        return result;
    }

    public static int maxMeetings2(int start[], int end[], int n) {
        meeting[] meetings= new meeting[n];
       for(int i=0;i<n;i++){
           meetings[i]= new meeting(start[i],end[i]);
       }
        Arrays.sort(meetings, (a, b) -> a.end - b.end);
//        int start[] = {1, 3, 0, 5, 8, 5}, end[] = {2, 4, 6, 7, 9, 9};  -> for reference debugging added here
        int result = 1;
        int endTime = meetings[0].end;
        for (int i = 0; i < n; i++) {
            if (meetings[i].start > endTime) {
                result++;
                endTime = meetings[i].end;
            }
        }
        return result;
    }
}