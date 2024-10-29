
import java.util.*;

class TopKFreqEleOld {
    public static void main(String[] args) {

        String s="ab_a";
//        isPalindrome(s);
        isPalindromeNumber(121);

    }
    public static boolean isPalindromeNumber(int x) {
        int num=x;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        if(rev==num){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[\\W_]", "").toLowerCase();
        System.out.println(s);
        for(int i=0, j=s.length()-1; i<=j; i++,j--){
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

}