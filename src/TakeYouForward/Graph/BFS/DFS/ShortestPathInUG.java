package TakeYouForward.Graph.BFS.DFS;

import TakeYouForward.Pair;

import java.util.*;


public class ShortestPathInUG {

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        int res[] = shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public static List<List<Pair<Integer,Integer>>> buildGraph(int V, int E, int[][] edges ){
        List<List<Pair<Integer,Integer>>> graph = new ArrayList<>();

        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        return graph;
    }
    public static int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair<Integer,Integer>>> graph = buildGraph(V,E,edges);
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i,visited,st,graph);
            }
        }
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for(Pair<Integer,Integer> pair: graph.get(node)){
                int adjacentNode = pair.getKey();
                int adjacentWeight = pair.getValue();
                if (dist[node] + adjacentWeight < dist[adjacentNode]) {
                    dist[adjacentNode] = dist[node] + adjacentWeight;
                }
            }
        }

        for(int i=0;i<V;i++) {if(dist[i]==((int)1e9)) dist[i]=-1;}
        return dist;
    }


    public static void topoSort(int vertex,boolean[] visited,Stack<Integer> stack,List<List<Pair<Integer,Integer>>> list){
        if(visited[vertex]){
            return;
        }
        visited[vertex]=true;
        for(Pair<Integer,Integer> neighbour: list.get(vertex)){
            topoSort(neighbour.getKey(),visited,stack,list);
        }
        stack.push(vertex);
    }

    /**
     *using BFS Approach
     */

    public int[] shortestPathModifiedBFS(int V, int E, int[][] edges) {
        // Code here
        List<List<Pair<Integer,Integer>>> graph = buildGraph(V,E,edges);
        int dist [] = new int[V];
        Arrays.fill(dist, (int)1e9);
        bfs(V,E,dist,graph,0);
        for(int i=0;i<V;i++) {if(dist[i]==((int)1e9)) dist[i]=-1;}
        return dist;
    }

    public void bfs(int V, int E, int dist[], List<List<Pair<Integer,Integer>>> graph, int src){
        dist[0]= 0;
        Queue< Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            int node =queue.remove();
            for(Pair<Integer,Integer> pair: graph.get(node)){
                int neighbor = (int) pair.getKey();
                int weight = (int) pair.getValue();
                int newDist = dist[node]+weight;
                if(newDist<dist[neighbor]) {
                    dist[neighbor] = newDist;
                    queue.add(neighbor);
                }
            }
        }
    }
}



