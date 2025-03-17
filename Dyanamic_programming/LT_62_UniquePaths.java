package Dyanamic_programming;
public class LT_62_UniquePaths {
    // pure-recursion

//    public static int uniquePaths(int m, int n) {
//        if(m == 1 || n == 1) return 1;
//        return (uniquePaths(m-1,n) + uniquePaths(m,n-1));
//    }

    // memoization
//    public int helper(int m, int n, int[][] memo) {
//        // Base case: If either m or n is 1, there's only one path
//        if (m == 1 || n == 1) return 1;
//
//        // Check memoization for previously computed values
//        int downMoved;
//        if (memo[m-1][n] != 0) {
//            downMoved = memo[m-1][n];
//        } else {
//            downMoved = helper(m-1, n, memo);
//            memo[m-1][n] = downMoved; // Store computed value in memo
//        }
//
//        int rightMoved;
//        if (memo[m][n-1] != 0) {
//            rightMoved = memo[m][n-1];
//        } else {
//            rightMoved = helper(m, n-1, memo);
//            memo[m][n-1] = rightMoved; // Store computed value in memo
//        }
//
//        // Return the total number of ways by moving down and right
//        return downMoved + rightMoved;
//    }
//
//    public int uniquePaths(int m, int n) {
//        // Initialize memoization table
//        int[][] memo = new int[m+1][n+1];
//        return helper(m, n, memo); // Call helper function with memoization
//    }

    // Tabulation

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (i == 0 || j == 0) dp[i][j] = 1;
               else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1]; // return last cell value
    }
}



