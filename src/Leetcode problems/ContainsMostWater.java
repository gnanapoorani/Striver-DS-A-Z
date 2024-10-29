class ContainsMostWater {
    public static void main(String[] args) {

        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = findMaxVolume(arr);
        System.out.println(result);

    }

    public static int findMaxVolume(int[] height) {
        int max = 0;
        int volume = 0;
        int i = 0;
        int j = height.length-1;
        int length;
        int minHeight;
        while (i < j) {
            length = j - i;
            if (height[i] < height[j]) {
                minHeight = height[i];
                i++;
            } else {
                minHeight = height[j];
                j--;
            }
            volume = length * minHeight;
            if (max < volume)
                max = volume;

        }
        return max;
    }
}
