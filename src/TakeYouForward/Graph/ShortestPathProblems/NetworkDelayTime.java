package TakeYouForward.Graph.ShortestPathProblems;

import java.util.*;

/**
 * Good solution
 * https://leetcode.com/problems/path-with-minimum-effort/solutions/1000195/thought-process-from-naive-bfs-to-dijkstra/
 * Naive BFS to dijkstra
 */

class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{1,2,1},{2,1,3}};
        System.out.println(networkDelayTime(times, 2, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int src) {
        int finalAnswer = 0;
        Map<Integer, List<int[]>> adjacencyMap = new HashMap<>();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src-1]=0;

        for (int[] edge : times) {
            adjacencyMap.putIfAbsent(edge[0], new ArrayList<>());
            adjacencyMap.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (!adjacencyMap.containsKey(node[0])) {
                continue;
            }
            int sourceCost = node[1];
            for (int[] neighbours : adjacencyMap.get(node[0])) {
                int neighbourTravelCost = sourceCost + neighbours[1];
                if(neighbourTravelCost<distance[neighbours[0]-1]){
                    distance[neighbours[0]-1] =neighbourTravelCost;
                    queue.offer(new int[]{neighbours[0], neighbourTravelCost});
                }
            }
        }
        for (int time : distance) {
            finalAnswer = Math.max(finalAnswer, time);
        }
        return finalAnswer==Integer.MAX_VALUE?-1:finalAnswer;
    }
}