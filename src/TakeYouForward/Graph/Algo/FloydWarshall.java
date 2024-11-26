package TakeYouForward.Graph.Algo;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class FloydWarshall {

    public static void main(String[] args) {
        int[][] grid = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(topoSortDFS(grid));
        System.out.println(topoSortBFS(grid));
    }

    static List<Integer> topoSortDFS(int[][] grid){
        int length=grid.length;
        List<Integer> result= new ArrayList<>();
        boolean[] visited= new boolean[length];

        Stack<Integer> st= new Stack<>();

        for(int i=0;i<length;i++){
            if(!visited[i]){
                doDFS(grid,i,st,visited);
            }
        }
        while(!st.isEmpty()){
         result.add(st.pop());
        }
        return result;
    }

    static void doDFS(int[][] grid,int index,Stack<Integer> st,boolean[] visisted){

        for(int node:grid[index]){
            if(visisted[node]==false){ //not visited
                doDFS(grid,node,st,visisted);
            }
        }
        st.push(index);
    }

    static int[] topoSortBFS(int[][] grid){
return new int[0];
    }

}