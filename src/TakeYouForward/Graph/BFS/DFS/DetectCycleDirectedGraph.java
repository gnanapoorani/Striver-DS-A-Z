package TakeYouForward.Graph.BFS.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class DetectCycleDirectedGraph {

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

        System.out.println(isCyclicDFS(5, list));
        System.out.println(isCyclicBFS(5, list));
    }

    public static boolean isCyclicDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (DFSCheck(adj, visited, pathVisited, i)) return true;
            }

        }
        return false;
    }

    public static boolean DFSCheck(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int currentNode) {
        visited[currentNode] = true;
        pathVisited[currentNode]=true;
        for (Integer adjacentNode : adj.get(currentNode)) {
            if (pathVisited[adjacentNode] || DFSCheck(adj, visited, pathVisited, adjacentNode)) {
                return true;  //There is a cycle
            }
        }
        pathVisited[currentNode]=false;
        return false;
    }

    /**
     * Here we are using  Kahn’s algorithm  for topological sorting,
     * if it successfully removes all vertices from the graph, it’s a DAG with no cycles.
     * If there are remaining vertices with in-degrees greater than  0  , it indicates the presence of at least
     * one cycle in the graph. Hence, if we are not able to get all the vertices in topological sorting then there must be at least one cycle.
     */
    public static boolean isCyclicBFS(int V,
                                   ArrayList<ArrayList<Integer>> adj) {

        // Stores in-degree of each vertex
        int[] inDegree = new int[V];

        // Queue to store vertices with 0 in-degree
        Queue<Integer> q = new LinkedList<>();
        int visited = 0; // Count of visited vertices

        // Calculate in-degree of each vertex
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        // Enqueue vertices with 0 in-degree
        for (int u = 0; u < V; u++) {
            if (inDegree[u] == 0) {
                q.offer(u);
            }
        }

        // BFS traversal
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;

            // Reduce in-degree of adjacent vertices
            for (int v : adj.get(u)) {
                inDegree[v]--;
                // If in-degree becomes 0, enqueue it
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // If not all vertices are visited, cycle
        return visited != V;
    }
}