package Dyanamic_programming;
public class spaceOptimize {
    public static int fib(int n){ // fibonacci(optimized space)
        int [] dp = new int[3]; // fixed 3 sized array --> S.C = O(1)
        // initialization
        dp[0] = 0;
        dp[1] = 1;

        if(n == 0 || n == 1) return dp[n];
        for(int i = 2; i <= n; i++){
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
        
    }
    public static void main(String[] args) {





    }
}
