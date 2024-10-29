package GeeksForGeeks;

import java.util.ArrayList;

class NumberOfWays {
    public static void main(String[] args) {
        System.out.println(numOfWays(12));
    }

    public static int numOfWays(int n) {
        if(n%2!=0 || n<4){
            return 0;
        }
        int count=0;
        int limit =n/2;
        for(int i=1;i<=limit/2;i++){
            count++;
        }
        return count*6;
    }


}
