class LongestLengthWithSumK{
    public static void main(String[] args){
        int nums[]={1,2,3,1,1,1};
        System.out.println(longestSubarrayWithSumK(nums,3));
    }

    public static int longestSubarrayWithSumK(int []a, long k) {
       int left=0,right=0,sum=0,maxLen=0;
       int n=a.length;
       while(left<n){
           while(right<n){
               sum+=a[right];
               if(sum==k){
                   maxLen=right-left+1;
               }
               if(sum>k){
                   break;
               }
               right++;

           }
           sum-=a[left];
           left++;
           if(sum==k){
               maxLen=right-left+1;
               right++;
           }
       }
       return maxLen;
    }
}