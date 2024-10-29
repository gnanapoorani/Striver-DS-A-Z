import java.util.Arrays;

class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        System.out.println(minEatingSpeed(piles, 1000000000));
    }

//   public static int minEatingSpeed(int[] piles, int h) {
//        int hourTaken = 0, low = 1, mid,ans=0;
//        int high = Arrays.stream(piles).max().getAsInt();
//
//        while (low <= high) {
//            mid = (low + high) / 2;
//            hourTaken = findHours(mid, piles);
//            if (h >= hourTaken) {// eating speed is high
//                ans= mid;
//                high = mid - 1;
//            } else { //hour permitted < eating speed
//                low = mid + 1;
//            }
//        }
//        return ans;
//    }
//    private static int findHours(int num, int[] piles) {
//        int hourTaken = 0;
//        for (int pile : piles) {
//            int currH = pile%num == 0 ? pile/num : pile/num+1;
//            hourTaken += currH;
//        }
//        return hourTaken;
//    }

    public static int minEatingSpeed(int[] piles, int h) {
        //二分法
        int right = Arrays.stream(piles).max().getAsInt();
        int left = 1,ans=0;

        while (left<=right){
            int mid = (left+right)/2;

            if (canEatAll(piles,h,mid)){
                right = mid-1;
                ans=mid;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    public static boolean canEatAll(int [] piles,int h,int k){
        int cnt = 0;
        for(int pile : piles){
            int currH = pile%k == 0 ? pile/k : pile/k+1;
            cnt += currH;
            if (cnt>=h){
                return false;
            }
        }
        return true;
    }
}