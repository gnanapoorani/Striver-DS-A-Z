package TakeYouForward.Graph.BFS.DFS;

import java.util.LinkedList;
import java.util.Queue;

class TopoSort {

    public static void main(String[] args) {
        int[][] grid = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(isBipartiteDFS(grid));
        System.out.println(isBipartiteBFS(grid));
    }

    public static boolean isBipartiteDFS(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length];
        for (int i = 0; i < length; i++) {
            if (color[i] == 0) {
                if (validColor(graph, color, 1, i) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validColor(int[][] graph, int[] color, int myColor, int node) {
        if (color[node] != 0) {  //Already colored
            return color[node] == myColor;
        }
        color[node] = myColor;
        for (int next : graph[node]) {
            if (!validColor(graph, color, -myColor, next)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartiteBFS(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (color[i] == 0) {
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int next : graph[node]) {
                        if (color[next] != 0) {
                            return color[next] != color[node];
                        } else {
                            queue.offer(next);
                            color[next] = -color[node];
                        }

                    }
                }
            }
        }
        return true;
    }

}