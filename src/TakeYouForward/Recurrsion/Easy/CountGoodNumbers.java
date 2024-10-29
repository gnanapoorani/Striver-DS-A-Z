
class CountGoodNumbers {
    public static void main(String[] args) {

        System.out.println(countGoodNumbers(4));
    }

    // Define MOD as a class variable for easier reference and readability
    public static long MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        int answer;
        answer = (int) (modPow(4, (n / 2)) * modPow(5, (n + 1) / 2) % MOD);
        return answer;
    }

    public static long modPow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        long temp = modPow(x, (n / 2));

        // If n is even, return (x^(n/2))^2
        if (n % 2 == 0) {
            return (temp * temp) % MOD;
        }
        // If n is odd, return (x^(n/2))^2 * x
        else {
            return (x * temp * temp) % MOD;
        }
    }
}