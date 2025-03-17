package Dyanamic_programming;

public class knapsack_zero_One_memoization {


    public static int maxProfit(int item, int[] wt, int[] val, int C, int[][] memo){ // item --> index of the item
        int pick = 0;
        int skip = 0;
        int result = 0;
        if (item == wt.length) return 0; // if we are out of array then always skip i.e. value added 0

        if (C >= wt[item]){ // pick only if capacity >= weight of the item
            // memo check start
            if (memo[item+1][C-wt[item]] != -1) result = memo[item+1][C-wt[item]];
            else{ // the data in memo not found
                result = maxProfit(item + 1, wt, val, C - wt[item],memo);
                memo[item+1][C-wt[item]] = result; // add calculated result into (memo)
            } //memo check end
            pick = val[item] + result;
        }

        // memo check start
        if (memo[item+1][C] != -1) result = memo[item+1][C];
        else{ // the data in memo not found
            result = maxProfit(item+1,wt,val,C,memo);
            memo[item+1][C] = result;
        } //memo check end
        skip = result;
        return Math.max(pick,skip); // return the maximum profit by doing either skip ot pick

    }
    public static void main(String[] args) {
        int[] val = {5,3,9,16};
        int[] wt =  {1,2,8,10};
        int Capacity = 8;
        int n = val.length; // n -> number of item
        int [][] memo = new int[n+1][Capacity + 1];
        
        // here item and capacity both changes that's why wee need 2d array for memoization
        // <item> changes from (0 -> n-1) and capacity changes from (capacity -> 0)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Capacity+1; j++) {
                memo[i][j] = -1; // filling the memo array completely with (-1)
            }
        }
        System.out.println(maxProfit(0,wt,val,Capacity,memo));
    }
}
