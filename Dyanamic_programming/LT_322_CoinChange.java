package Dyanamic_programming;
public class LT_322_CoinChange {
    // pure Recursion
//    public int countCoin(int[] coins, int amount, int idx){
//        if (idx == coins.length){
//            if (amount == 0) return 0;
//            else return Integer.MAX_VALUE;
//        }
//
//        int pick = Integer.MAX_VALUE;
//        if(amount >= coins[idx]) {
//            int res = countCoin(coins, amount - coins[idx], idx);
//            if(res != Integer.MAX_VALUE) {
//                pick = 1 + res;
//            }
//        }
//
//        int skip = countCoin(coins, amount, idx + 1);
//        return Math.min(pick, skip);
//    }
//
//    public int coinChange(int[] coins, int amount) {
//
//        int ans = countCoin(coins, amount, 0);
//        if(ans == Integer.MAX_VALUE) return -1;
//        return ans;
//    }

    // memoization
    public int countCoin(int[] coins, int amount, int idx, int[][] memo){
        if (idx == coins.length){
            if (amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }

        // pick wala part
        int pick = Integer.MAX_VALUE;
        if(amount >= coins[idx]) {
            int memoResult;
            // memo check
            if (memo[amount-coins[idx]][idx] != -1)  memoResult = memo[amount-coins[idx]][idx]; // result found
            else {
                memoResult = countCoin(coins, amount - coins[idx], idx, memo);
                memo[amount-coins[idx]][idx] = memoResult; // memo update
            } // memo check end

            if(memoResult != Integer.MAX_VALUE) {
                pick = 1 + memoResult;
            }
        }

        // skip wala part
        int memoResult;
        // memo check
        if (memo[amount][idx+1] != -1)  memoResult = memo[amount][idx+1]; // result found
        else {
            memoResult = countCoin(coins, amount, idx+1, memo);
            memo[amount][idx+1] = memoResult; // memo update
        } // memo check end

        int skip = memoResult;
        return Math.min(pick, skip);
    }

    public int coinChange(int[] coins, int amount) {
        // amount changes (amount -> 0) & idx changes (0 -> coins.length)

        int[][] memo = new int[amount+1][coins.length+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }

        int ans = countCoin(coins, amount, 0, memo);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
