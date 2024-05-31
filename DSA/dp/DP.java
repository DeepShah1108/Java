package DSA.dp;

public class DP {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibWithMemo(n));
        System.out.println(fibWithTab(n));
    }

//    DP using Memeziation
    static int fibWithMemo(int n) {
        int dp[] = new int[n+1];
        if(n <= 1) {
            return n;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fibWithMemo(n-1) + fibWithMemo(n-2);

        return dp[n];
    }


//    DP using Tabulation
    static int fibWithTab(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
