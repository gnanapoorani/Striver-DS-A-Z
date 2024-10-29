package TakeYouForward.Graph.BFS.DFS;

import javafx.util.Pair;

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

    public static boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj) {
        int length = adj.size();
        int[] visited = new int[length + 1];
        Arrays.fill(visited, -1);
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == -1) {
                if (BFSCheck(adj, visited, 0, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean BFSCheck(ArrayList<ArrayList<Integer>> adj, int[] visited, int currentNode, int parentNode) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(currentNode, parentNode));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> visitedNode = queue.poll();
            int node = visitedNode.getKey();
            int parent = visitedNode.getValue();
            for (int adjacentNode : adj.get(node)) {
                if (visited[adjacentNode] == -1) {
                    queue.add(new Pair<>(adjacentNode, node));
                    visited[adjacentNode] = 1;
                } else {
                    if (adjacentNode != parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}