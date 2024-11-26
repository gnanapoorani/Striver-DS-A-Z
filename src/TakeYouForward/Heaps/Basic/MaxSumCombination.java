package TakeYouForward.Heaps.Basic;

import java.util.*;

public class MaxSumCombination {

    public static void main(String[] args) {
        int a[] = {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
        int groupSize = 3;
        int N = 4;
        int K = 3;
        int A [ ] = {1, 4, 2, 3};
        int B [ ] = {2, 5, 1, 6};
        System.out.print(groupSize + "Max Combination sum  using pq and set");
        System.out.println(maxCombinations(N,K,A,B));
    }

        static List<Integer> maxCombinations(int N, int K, int[] A, int[] B) {
            // Sort both arrays in descending order
            Arrays.sort(A);
            Arrays.sort(B);

            List<Integer> result = new ArrayList<>();
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));
            Set<String> visited = new HashSet<>();

            // Add the initial max pair (A[0] + B[0]) and its indices (0, 0) to the heap
            maxHeap.offer(new int[]{A[N-1] + B[N-1], N - 1, N - 1});
            visited.add((N-1) + "," + (N-1));

            while (result.size() < K && !maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                int sum = top[0];
                int i = top[1];
                int j = top[2];

                // Add the current maximum sum to the result
                result.add(sum);

                // Add the next two possible pairs (i-1, j) and (i, j-1) to the heap if not already visited
                if (i > 0 && visited.add((i-1) + "," + j)) {
                    maxHeap.offer(new int[]{A[i-1] + B[j], i - 1, j});
                }
                if (j > 0 && visited.add(i + "," + (j-1))) {
                    maxHeap.offer(new int[]{A[i] + B[j-1], i, j - 1});
                }
            }

            return result;
        }
    }