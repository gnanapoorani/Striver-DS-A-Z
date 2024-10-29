package GeeksForGeeks;

class MaximumSubArrayMiniPossible {
    public static void main(String[] args){
        int[] arr={12,2,8,1,7,13};
        int N=6,K=4;
        System.out.println(splitArray(arr,N,K));
    }
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int start=0;
        int end=0;

        for(int i=0; i<N;i++){
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        //minimum  of maximum sum of suarray we get after dividing arr into different subarray
        //start = max element

        // maximum of maximum sum of subarray we get after arr is the sum of whole arr
        //end  = sum of all elements

        while(start<end){
            int mid = start + (end-start)/2;
            int sum=0;
            int pieces=1;

            for(int i=0; i<N;i++){
                if(sum+arr[i] > mid){
                    sum=arr[i];
                    pieces++;
                }else{
                    sum += arr[i];
                }
            }
            if(pieces > K){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
}