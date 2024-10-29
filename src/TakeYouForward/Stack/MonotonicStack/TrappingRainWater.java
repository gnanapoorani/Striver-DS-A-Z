package TakeYouForward.Stack.MonotonicStack;

class TrappingRainWater {

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("heights" + trap(heights));
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length-1, leftMax = -1, rightMax = -1;
        int waterLevel = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                waterLevel += leftMax - height[left++];
            } else {
                waterLevel += rightMax - height[right--];
            }
        }
        return waterLevel;
    }
}