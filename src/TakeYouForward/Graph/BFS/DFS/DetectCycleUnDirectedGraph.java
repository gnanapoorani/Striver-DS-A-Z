
package TakeYouForward.Graph.BFS.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class DetectCycleUnDirectedGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(1).add(0);
        list.get(1).add(2);
        list.get(1).add(4);
        list.get(2).add(1);
        list.get(2).add(3);
        list.get(3).add(2);
        list.get(3).add(4);
        list.get(4).add(1);
        list.get(4).add(3);

        System.out.println(isCycleDFS(list));
        System.out.println(isCycleBFS(list));
    }

    public static boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj) {
        int length = adj.size();
        int[] visited = new int[length + 1];
        Arrays.fill(visited, -1);
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == -1) {
                if (DFSCheck(adj, visited, 0, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DFSCheck(ArrayList<ArrayList<Integer>> adj, int[] visited, int currentNode, int parentNode) {
        visited[currentNode] = 1;
        for (Integer adjacentNode : adj.get(currentNode)) {
            if (visited[adjacentNode] != 0 && adjacentNode != parentNode) {
                return true;  //There is a cycle
            }
            return DFSCheck(adj, visited, adjacentNode, currentNode);
        }
        return false;
    }

    // Function to detect cycle in an undirected graph with checking parent node concept
    public static  boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] != 1) {
                if (detectCycle(adj, i, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static  boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int x, int[] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, -1});
        vis[x] = 1;
        while (!q.isEmpty()) {
            int parent = q.peek()[1];
            int adjacent = q.peek()[0];
            q.poll();
            for (int i : adj.get(adjacent)) {
                if (vis[i] != 1) {
                    vis[i] = 1;
                    q.add(new int[]{i, adjacent});
                } else if (i != parent) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Without using parent node check
     */
    public static boolean isCyclicConnected(ArrayList<Integer>[] adj, int s, int V, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.poll();

            if (visited[v]) {
                return true; // Cycle detected
            }

            visited[v] = true; // Mark as visited

            for (int it : adj[v]) {
                if (!visited[it]) {
                    q.add(it);
                }
            }
        }
        return false;
    }

    public static boolean isCyclicDisconnected(ArrayList<Integer>[] adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicConnected(adj, i, V, visited)) {
                return true;
            }
        }
        return false;
    }
}
