package TakeYouForward.Graph.BFS.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EventualSafeStates {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {4}, {5}, {}, {}};
        System.out.println(eventualSafeNodesDFS(graph));
        System.out.println(eventualSafeNodesBFS(graph));
    }

    public static List<Integer> eventualSafeNodesDFS(int[][] graph) {
        List<Integer> safeNodes= new ArrayList<>();
        int n = graph.length;
        boolean[] visited= new boolean[n];
        boolean[] pathVisited= new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
               detectCycleDFS(graph,i,visited,pathVisited);
            }
        }
        for(int i=0;i<n;i++){
            if(!pathVisited[i]){
                safeNodes.add(i);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }

    static boolean detectCycleDFS(int[][] graph, int node, boolean[] visited,boolean[] pathVisited) {
        visited[node]=true;
        pathVisited[node]=true;
        for(int adjacentNode : graph[node]) {


        }
        pathVisited[node]=false;
        return false;
    }

    public static List<Integer> eventualSafeNodesBFS(int[][] graph) {
        List<Integer> result = new ArrayList<>();

        return result;
    }
}