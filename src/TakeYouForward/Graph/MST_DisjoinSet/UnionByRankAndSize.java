package TakeYouForward.Graph.MST_DisjoinSet;

public class UnionByRankAndSize {

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5};
        System.out.println(find(A, 2));
        unionSet(A, 2, 3);
    }

    int[] size;
    int[] parent;

    UnionByRankAndSize(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    static int find(int A[], int X) {
        if (A[X] == X) return X;
        return A[X] = find(A, A[X]);
    }

    static void unionSet(int A[], int X, int Z) {
        int ulpX = find(A, X);
        int ulpZ = find(A, Z);
        A[ulpX] = ulpZ;
    }

    int findParent(int u) {
        if (u == parent[u]) return u;
        return parent[u] = findParent(parent[u]);
    }

    void unionBySize(int u, int v) {
        int ulpX = findParent(u);
        int ulpZ = findParent(v);
        if(ulpZ==ulpX){
            return ;
        }else{
            if(size[ulpX]>size[ulpZ]){
                parent[ulpZ]=ulpX;
                size[ulpX]+=size[ulpZ];
            }else{
                parent[ulpX]=ulpZ;
                size[ulpZ]+=size[ulpX];
            }
        }
    }
}
