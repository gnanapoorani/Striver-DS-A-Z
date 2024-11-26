package TakeYouForward.Graph.Algo;


import java.util.*;

class TopoSortBFS_DFS {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3},
                {4, 5}, {5, 1}, {5, 2}};

        System.out.println(topoSortDFS(edges));
        System.out.println(topoSortBFS(edges));
    }

    static List<Integer> topoSortDFS(int[][] grid) {
        int length = grid.length;
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                doDFS(grid, i, st, visited);
            }
        }
        while (!st.isEmpty()) {
            result.add(st.pop());
        }
        return result;
    }

    static void doDFS(int[][] grid, int index, Stack<Integer> st, boolean[] visisted) {
        visisted[index] = true;
        for (int node : grid[index]) {
            if (visisted[node] == false) { //not visited
                doDFS(grid, node, st, visisted);
            }
        }
        st.push(index);
    }

    static List<Integer> topoSortBFS(int[][] grid) {
        int n = grid.length;
        int[] inDegree = new int[n];
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edges : grid) {
            adj.get(edges[0]).add(edges[1]);
        }

        for (int[] edges : grid) {
            for (int val : edges) {
                inDegree[val]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int index=queue.poll();
            result.add(index);
            for(int node:grid[index]){
                inDegree[node]--;
                if(inDegree[node]==0){
                    queue.offer(node);
                }
            }
        }
        return result;
    }

}