package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WaterThePlants {

    public static void main(String[] args) {
        int[] gallery = {-1, 2, 2, -1, 0, 0};
        System.out.println(min_sprinklers(gallery, 6));
    }

    static int min_sprinklers(int gallery[], int n) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < gallery.length; i++) {
            if (gallery[i] != -1) {
                arr.add(new int[]{i - gallery[i], gallery[i] + i});
            }
        }
        Collections.sort(arr,(a,b)->a[0]-b[0]);
        int i=0,target=0,count=0;
        while(target<n){
            if(i==arr.size()||arr.get(i)[0]>target ){
                return -1;
            }
            int max_range=arr.get(i)[1];
            while(i+1<arr.size() && arr.get(i)[0]<=target){
                i++;
                max_range=Math.max(max_range,arr.get(i)[1]);
            }
            if(max_range<target){
                return  -1;
            }
            count++;
            target=max_range+1;
            i++;
        }

return count;
    }
}