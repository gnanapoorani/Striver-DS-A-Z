package TakeYouForward.Graph.ShortestPathProblems;

import java.util.Arrays;

/**
 * question
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 * Good solution
 * Naive BFS to dijkstra
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/solutions/477660/java-count-number-of-connected-components-clean-code/
 */

class SmallNeighboursAtDistance {

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(findTheCity(5, edges, 2));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int maxCount = Integer.MAX_VALUE, city = -1;
        int[][] distance = new int[n][n];

        for (int[] row : distance) {
            Arrays.fill(row, 10001);
        }

        for (int i = 0; i < n; i++) {
            distance[i][i] = 0;
        }
        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = distance[edge[1]][edge[0]] = edge[2];
        }


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= maxCount) {
                maxCount = count;
                city = i;
            }
        }

        return city;
    }
}