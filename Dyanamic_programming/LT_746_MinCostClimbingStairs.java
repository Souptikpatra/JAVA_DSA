package Dyanamic_programming;

import java.util.HashMap;

class minCost{

    // memoization

    HashMap<Integer, Integer> memo = new HashMap<>(); // Stores computed costs for positions (memoization)

    public int minCost(int[] cost, int currentPos) { // Recursive function to compute min cost at `currentPos`
        if (currentPos <= 1) return cost[currentPos]; // Base case: return cost at step 0 or 1

        int prev1 = currentPos - 1; // Represents the previous step (one step down)
        int prev2 = currentPos - 2; // Represents two steps down

        int cost1; // Stores the computed minimum cost from `prev1`
        int cost2; // Stores the computed minimum cost from `prev2`

        // Check if `prev1` cost is already calculated (memoization)
        if (memo.containsKey(prev1)) {
            cost1 = memo.get(prev1);
        } else {
            cost1 = minCost(cost, prev1);
            memo.put(prev1, cost1); // Store computed result for `prev1`
        }

        // Check if `prev2` cost is already calculated (memoization)
        if (memo.containsKey(prev2)) {
            cost2 = memo.get(prev2);
        } else {
            cost2 = minCost(cost, prev2);
            memo.put(prev2, cost2); // Store computed result for `prev2`
        }

        return cost[currentPos] + Math.min(cost1, cost2); // Compute the minimum cost from `currentPos` to bottom (0 or 1)
    }

    public int minCostClimbingStair(int[] cost) { // Main function to compute the minimum climbing cost
        int n = cost.length;
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2)); // Start from last two steps
    }

    // tabulation
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0]; dp[1] = cost[1]; //initial first 2 stair cost

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        int result = Math.min(dp[n-1],dp[n-2]);
        return result;
    }




}

public class LT_746_MinCostClimbingStairs {

    public static void main(String[] args) {

    }
}
