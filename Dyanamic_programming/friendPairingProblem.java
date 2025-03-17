package Dyanamic_programming;

import java.util.HashMap;

public class friendPairingProblem {
    // pure recursion

//    public static int f(int n){
//        if (n == 1 || n == 2) return n; // base case
//        return f(n-1) + (n-1) * f(n-2);
//    }

    // memoization
    static HashMap<Integer,Integer> memo = new HashMap<>();
    public static int fn(int n){
        if (n == 1 || n == 2) return n; // base case

        int result = 0;
        if(memo.containsKey(n)) return memo.get(n);
        else {
            result = fn(n-1) + (n-1) * fn(n-2);
            memo.put(n,result);
        }
        return result;
    }

    // Tabulation
    public static int f(int n){
        int len = n+1;
        int[] dp = new int[len];
        dp[1] = 1; dp[2] = 2; // base case fill
        for (int i = 3; i < len; i++) {
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        System.out.println(f(16));

    }
}
