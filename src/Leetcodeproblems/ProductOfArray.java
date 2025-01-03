
import java.util.Map;
import java.util.HashMap;

class ProductOfArray {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            res[i] = nums[i+1] * res[i+1];
        }

        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i != 0) left *= nums[i-1];
            res[i] *= left;
        }
        return res;
    }
    public static void main(String[] args) {

        int nums[]= {2,3,5,0};
        double sum=0;
        int negativeCounter=0;
        int zeroCounter=0;
for(int i=0;i<nums.length;i++){
    if(nums[i]<0){
        negativeCounter++;
    }

    if(nums[i]==0){
        zeroCounter++;
    }else{
        sum=Math.log10(Math.abs(nums[i]))+sum;
    }
}
        double result[]= new double[nums.length];
double value;

for(int i=0;i<nums.length;i++){
    if(zeroCounter>1){
        result[i]=0;
    }else {
        if(zeroCounter==1){
            if(nums[i]==0){
                if(negativeCounter%2 ==0){
                    result[i]= Math.pow(10,sum);
                }else{
                    result[i]= 0 - Math.pow(10,sum);
                }
            }
            else{
                result[i]=0;
            }
        }
       else {
            value = sum - Math.log10(Math.abs(nums[i]));

            if (nums[i] < 0) {
                if (negativeCounter - 1 % 2 == 0) {
                    result[i] = Math.pow(10, value);
                } else {
                    result[i] = 0 -  Math.pow(10, value);
                }
            } else {
                if (negativeCounter % 2 == 0) {
                    result[i] =  Math.pow(10, value);
                } else {
                    result[i] = 0 - Math.pow(10, value);
                }

            }
        }
    }

}
for(int i=0;i<nums.length;i++){
    System.out.println(result[i]);
}


    }
    public static int[] twoSum(int[] nums) {

        final int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            int multiply = 1;
            while (j < nums.length) {
                if (j != i) {
                    multiply = multiply * nums[j];
                }
                j++;
            }
            result[i] = multiply;
        }
        return result;
    }
}