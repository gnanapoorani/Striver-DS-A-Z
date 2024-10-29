import java.util.Arrays;

class PowerImpl2323 {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }

    public static double myPow1(double x, int n) {
        double result = 1;
        if(x==1){
            return x;
        }
        boolean isNegative = false;
        if (n < 0) {
            n = -n;
            isNegative = true;
        }
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        if (isNegative) {
            result = 1.0 / result;
        }
        return result;
    }

    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n < 0) {
            n = -n;
            x = 1/x;
        }

        return (n%2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
    }

    public double myPowUsingBitManipulation(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        while(n != 0){
            if((n & 1) == 1){
                ans *= x;
            }
            x *= x;
            n = n >>> 1;
        }
        return ans;
    }


}