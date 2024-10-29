package TakeYouForward.Graph.BFS.DFS;

import java.util.ArrayList;

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

    public static boolean isCyclicBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        return true;
    }

}