package TakeYouForward.Greedy;

import java.util.Arrays;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class MinimumPlatforms {

    public static void main(String[] args) {
        int start[] = {900, 940, 950, 1100, 1500, 1800}, end[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(start, end, 6));
    }

    static class meeting {
        int start;
        int end;
        meeting(int start,int end){
            this.start=start;
            this.end=end;
        }
    }

    public static int findPlatform(int start[], int end[], int n) {
        int[][] schedule = new int[n][2];

        for (int i = 0; i < n; i++) {
            schedule[i][0] = start[i];
            schedule[i][1] = end[i];
        }

        Arrays.sort(schedule, (a, b) -> a[1] - b[1]);
        int platform_needed = 1;
        int endTime = schedule[0][1];
        for (int i = 1; i < n; i++) {
            int arrivalTime=schedule[i][0];
            if (arrivalTime < endTime) {
                platform_needed++;
            }
            endTime = schedule[i][1];
        }
        return platform_needed;
    }

    public static int maxMeetings2(int start[], int end[], int n) {
        meeting[] meetings= new meeting[n];
       for(int i=0;i<n;i++){
           meetings[i]= new meeting(start[i],end[i]);
       }


        Arrays.sort(meetings, (a, b) -> a.end - b.end);
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