package TakeYouForward.Graph.ShortestPathProblems;

import java.util.*;

/**
 * Good solution
 * https://leetcode.com/problems/path-with-minimum-effort/solutions/1000195/thought-process-from-naive-bfs-to-dijkstra/
 * Naive BFS to dijkstra
 */

class MinMultiplyToReachEnd {

    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        System.out.println(minimumMultiplications(arr, 7, 66175));
    }

    static int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        int[] distance=new int[mod];
        Arrays.fill(distance,(int)1e9);
        distance[start]=0;
        Queue<int[]> queue = new PriorityQueue<>((a1,a2)->Integer.compare(a1[1],a2[1]));
        queue.offer(new int[]{start, 0});//src,steps in queue

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int currValue = node[0];
            int steps = node[1];

            for (int num : arr) {
                int nextValue = (currValue * num) % mod;
                int currStep =steps;
                if(currValue==end){
                    return currStep;
                }
                if(currStep+1 <distance[nextValue]){
                    distance[nextValue]= currStep+1;
                    queue.offer(new int[]{nextValue, currStep+1});
                }
            }
        }
       return -1;
    }
}