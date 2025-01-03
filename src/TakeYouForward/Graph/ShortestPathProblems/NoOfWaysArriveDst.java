package TakeYouForward.Graph.ShortestPathProblems;

import java.util.*;

/**
 * question -https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
 * Good solution
 * <p>
 * Naive BFS to dijkstra
 */

class NoOfWaysArriveDst {

    public static void main(String[] args) {
        int[][] roads = {{1,0,2348},{2,1,2852},{2,0,5200},{3,1,12480},{2,3,9628},{4,3,7367},{4,0,22195},{5,4,5668},
    {1,5,25515},{0,5,27863},{6,5,836},{6,0,28699},{2,6,23499},{6,3,13871},{1,6,26351},{5,7,6229},{2,7,28892},
        {1,7,31744},{3,7,19264},{6,7,5393},{2,8,31998},{8,7,3106},{3,8,22370},{8,4,15003},{8,6,8499},{8,5,9335},
        {8,9,5258},{9,2,37256},{3,9,27628},{7,9,8364},{1,9,40108},{9,5,14593},{2,10,45922},{5,10,23259},{9,10,8666},
        {10,0,51122},{10,3,36294},{10,4,28927},{11,4,25190},{11,9,4929},{11,8,10187},{11,6,18686},{2,11,42185},{11,3,32557},{1,11,45037}};

        System.out.println(countPaths(12, roads));
    }

    public static int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);
        long[] distance = new long[n];
        int[] ways = new int[n];
        ways[0]=1;
        Arrays.fill(distance,Long.MAX_VALUE);
//        ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            adjacencyList.add(new ArrayList<>());
//        }
//        for (int[] road : roads) {
//            int intersection1 = road[0], intersection2 = road[1], travelTime = road[2];
//            adjacencyList.get(intersection1).add(new int[]{ intersection2,travelTime});
//            adjacencyList.get(intersection2).add(new int[]{intersection1,travelTime});
//        }
        Map<Integer, List<long[]>> adjacencyMap = new HashMap<>();
        for (int[] road : roads) {
            int fromPt = road[0];
            int toPt = road[1];
            int cost = road[2];
            adjacencyMap.putIfAbsent(fromPt, new ArrayList<>());
            adjacencyMap.get(fromPt).add(new long[]{toPt, cost});
            adjacencyMap.putIfAbsent(toPt, new ArrayList<>());
            adjacencyMap.get(toPt).add(new long[]{fromPt, cost});
        }

        // Create a priority queue for Dijkstra's algorithm
        PriorityQueue<long[]> queue = new PriorityQueue<>((a1, a2) -> Long.compare(a1[1], a2[1]));
//        Queue<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[]{0, 0}); //src,cost - queue will be storing
        while (!queue.isEmpty()) {
            long[] node = queue.poll();
            long fromPt = node[0];
            long pathCost = node[1];
            if (!adjacencyMap.containsKey((int)fromPt)) {
                continue;
            }
            for (long[] neighbours : adjacencyMap.get((int)fromPt)) {
                long toPt = neighbours[0];
                long travelCost = neighbours[1];
                long newCost=(pathCost+travelCost)%mod;

                if(newCost<distance[(int)toPt]){ //new short dist
                    distance[(int)toPt]=newCost%mod;
                    ways[(int)toPt]=ways[(int)fromPt];
                    queue.offer(new long[]{toPt,newCost});
                }else if(newCost==distance[(int)toPt]){
                    ways[(int)toPt]+=ways[(int)fromPt]%mod;
                }

            }
        }
        return (ways[n - 1])%mod;
    }
}