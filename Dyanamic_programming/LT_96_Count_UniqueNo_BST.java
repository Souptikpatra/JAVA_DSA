package Dyanamic_programming;

import java.util.Arrays;

public class LT_96_Count_UniqueNo_BST {
    // pure recursion

    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1; // base case
        int result = 0;
        for (int i = 0; i < n; i++) { // making each node as root one by one
            result += (numTrees(i) * numTrees(n-i-1));
        }
        return result;
    }

    // memoization
//    int helper(int n,int[] memo){
//        if (n == 0 || n == 1) return 1; // base case
//        // memo check
//        if (memo[n] != -1) return memo[n];
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            result += (helper(i,memo) * helper(n-i-1,memo));
//            memo[n] = result;
//        }
//        return result;
//    }
//    public int numTrees(int n) {
//        int[] memo = new int[n+1];
//        Arrays.fill(memo,-1);
//        return helper(n,memo);
//    }
    public static void main(String[] args) {

    }
}
