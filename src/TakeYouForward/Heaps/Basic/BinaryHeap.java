package TakeYouForward.Heaps.Basic;

public class BinaryHeap {
    public static void main(String[] args) {
        int[] num = {80, 13, 9, 5, 11, 1};
        System.out.println(isBinaryMaxHeap(num));
    }
    public static boolean isBinaryMaxHeap(int[] nums) {
        boolean result = false;
        int i = 0;
        int limit = nums.length;
        while (i <= (limit / 2)) {
            int left = getLeft(i);
            int right = getRight(i);
            if (left < nums.length && nums[i] > nums[left]) {
                i++;
            } else {
                return false;
//                if (right < nums.length && nums[i] > nums[right]) {
//                    i++;
//                } else {
//                    return false;
//                }
            }

        }
        return result;
    }

        static int getLeft( int j){
            return (j * 2) + 1;
        }

        static int getRight ( int j){
            return (j * 2) + 2;
        }

//        boolean heapChecker ( int nums[], int i, int n)
//        {
//            if (i > (n - 1) / 2) {
//                return true;
//            }
//
//            if ((nums[i] > nums[(2 * i) + 1]) && (nums[i] > nums[(2 * i) + 2]))&&
//            heapChecker(nums, (2 * i) + 1, n) && heapChecker(nums, (2 * 1) + 2, n)){
//            return true;
//        }

        }
