//2147483647 - Int Max value
//-2147483647 - 1 int min value
class RearrangeBySign {
    public static void main(String[] args) {
        int[] nums = {-2, 3, 1, -5, -4, -6, 2, 7};
        nums = rearrangeArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }


    public static int[] rearrangeArray(int[] nums) {
        int positive = 0, negative = 0;
        if (nums[0] < 0) {
            while (nums[positive] < 0) {
                positive++;
            }
        }
        int newArray[] = new int[nums.length];
        newArray[0] = nums[positive];
        positive++;
        for (int i = 1; i < nums.length; i++) {
            if (newArray[i - 1] > 0) {
                while (nums[negative] > 0) {
                    negative++;
                }
                newArray[i] = nums[negative];
                negative++;
            } else {
                while (nums[positive] < 0) {
                    positive++;
                }
                newArray[i] = nums[positive];
                positive++;
            }

        }
        return newArray;
    }


}