package GeeksForGeeks;

class CountPossibleWaysBuilding{
    public static void main(String[] args){
        System.out.println(TotalWays(10));
    }
    public static int TotalWays(int N) {
        if(N==1) return 4;
        long dp[]= new long[N+1];
        dp[0]=1;
        dp[1]=2;
        int mod=11223;
        for(int i=2;i<=N;i++){
            dp[i]=dp[i-1]+dp[i-2]  % 1000000007;
        }
      return (int) (dp[N]*dp[N])  % 1000000007;
    }
}