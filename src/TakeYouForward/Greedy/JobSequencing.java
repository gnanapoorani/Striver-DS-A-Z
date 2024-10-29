package TakeYouForward.Greedy;

import java.util.Arrays;
import java.util.Comparator;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class JobSequencing {

    static class Job {
        int id, deadline,profit;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static void main(String[] args) {
        Job j1 = new Job(1, 2, 100);
        Job j2 = new Job(2, 1, 150);
        Job j3 = new Job(3, 1, 500);
        Job j4 = new Job(4, 2, 50);
        Job arr[] = {j1, j2, j3,j4};
        int result[]=JobScheduling(arr, 3);
        System.out.println(result[0]+" "+result[1]);
    }
    static class  profitComparator implements Comparator<Job> {
        public int compare(Job j1, Job j2){
            if(j1.profit < j2.profit) return 1;
            else if(j1.profit == j2.profit) return 0;
            else return -1;
        }
    }

    //Function to find the maximum profit and the number of jobs done.
    static int[] JobScheduling(Job arr[], int n) {
//        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        Arrays.sort(arr, new profitComparator());
        int result[]=new int[2];
        boolean deadline[]= new boolean[n];
        for(Job job:arr){
            for(int j=job.deadline;j>=1;j--){
                if(deadline[j]==false){
                    deadline[j]=true;
                    result[0]++;
                    result[1]+=job.profit;
                }
            }
        }
        return result;
    }
}