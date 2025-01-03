package TakeYouForward.Graph.ShortestPathProblems;

import java.util.*;

/**
 * Good solution
 * https://leetcode.com/problems/path-with-minimum-effort/solutions/1000195/thought-process-from-naive-bfs-to-dijkstra/
 * Naive BFS to dijkstra
 */

class CheapestFlightKstops {

    static int finalAnswer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(findCheapestPrice(3, grid, 0, 2, 0));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        /**
         * We have to convert edge list to adjacency list either by using Arraylist or by Map
         */
        ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] path : flights) {
            adjacencyList.get(path[0]).add(new int[]{path[1], path[2]});
        }
        Map<Integer, List<int[]>> adjacencyMap = new HashMap<>();
        for (int[] path : flights) {
            adjacencyMap.putIfAbsent(path[0], new ArrayList<>());
            adjacencyMap.get(path[0]).add(new int[]{path[1], path[2]});
        }
        cheapestPriceHelperDijikstra(src, dst, k, 0, adjacencyMap);
        return finalAnswer == Integer.MAX_VALUE ? -1 : finalAnswer;
    }

    public static void cheapestPriceHelperDijikstra(int src, int dst, int k, int cost, Map<Integer, List<int[]>> adjacencyMap) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            if (k < 0) {
                break;
            }
            int[] node = pq.poll();
            int travel_cost = 0;
            if (node != null) {
                travel_cost = node[1];
            }
            if (!adjacencyMap.containsKey(node[0])) {
                continue;
            }
            for (int[] neighbours : adjacencyMap.get(node[0])) {
                int neighbourEdgeCost = neighbours[1] + travel_cost;
                if (neighbourEdgeCost > finalAnswer) {
                    continue; // dont add that edge into queue -> pruning
                }
                if (neighbours[0] == dst) {
                    finalAnswer = Math.min(finalAnswer, neighbourEdgeCost);
                }
                pq.offer(new int[]{neighbours[0], neighbourEdgeCost});
            }
            k--;
        }
    }

    public static void cheapestPriceHelperBfs(int src, int dst, int k, int cost, Map<Integer, List<int[]>> adjacencyMap) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{src, 0});
        while (!queue.isEmpty()) {
            if (k < 0) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int travel_cost = 0;
                if (node != null) {
                    travel_cost = node[1];
                }
                if (!adjacencyMap.containsKey(node[0])) {
                    continue;
                }
                for (int[] neighbours : adjacencyMap.get(node[0])) {
                    int neighbourEdgeCost = neighbours[1] + travel_cost;
                    if (neighbourEdgeCost > finalAnswer) {
                        continue; // dont add that edge into queue -> pruning
                    }
                    if (neighbours[0] == dst) {
                        finalAnswer = Math.min(finalAnswer, neighbourEdgeCost);
                    }
                    queue.offer(new int[]{neighbours[0], neighbourEdgeCost});
                }
            }
            k--;
        }
    }

    public static void cheapestPriceHelperDfs(int src, int dst, int k, int cost, Map<Integer, List<int[]>>
            adjacencyMap) {

        if (src == dst) {
            finalAnswer = cost;
            return;
        }
        if (k < 0)
            return;
        if (!adjacencyMap.containsKey(src)) {
            return;
        }
        for (int[] adj : adjacencyMap.get(src)) {
            if (cost + adj[1] < finalAnswer) {
                cheapestPriceHelperDfs(adj[0], dst, k - 1, cost + adj[1], adjacencyMap);
            }
        }
    }


}