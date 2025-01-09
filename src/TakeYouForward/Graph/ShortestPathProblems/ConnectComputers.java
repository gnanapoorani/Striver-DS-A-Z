package TakeYouForward.Graph.ShortestPathProblems;

/**
 * question
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * Good solution
 * Naive BFS to dijkstra
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/solutions/477660/java-count-number-of-connected-components-clean-code/
 */

class ConnectComputers {

    public static void main(String[] args) {
        int[][] connected = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3},{2,3}};
        System.out.println(makeConnected(6, connected));
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] edge : connections) {
            int p1 = findParent(parent, edge[0]);
            int p2 = findParent(parent, edge[1]);
            if (p1 != p2) { // Not a parent
                parent[p1] = p2;
                components--;
            }
        }
        return components-1;
    }

    public static int findParent(int[] parent, int computerId) {
        while(computerId!=parent[computerId]){
              computerId=parent[computerId];
        }
        return computerId;

    }
}