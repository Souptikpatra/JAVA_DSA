package Dyanamic_programming;

public class Knapsack_zero_one_recursion {

    public static int maxProfit(int item, int[] wt, int[] val, int C){ // item --> index of the item
        int pick = 0;
        int skip = 0;
        if (item == wt.length) return 0; // if we are out of array then always skip i.e. value added 0

        if (C >= wt[item]){ // pick only if capacity >= weight of the item
            pick = val[item] + maxProfit(item + 1, wt, val, C - wt[item]);
        }
        skip = maxProfit(item+1,wt,val,C);
        return Math.max(pick,skip); // return the maximum profit by doing either skip ot pick

    }
    public static void main(String[] args) {
        int[] val = {5,3,9,16};
        int[] wt =  {1,2,8,10};
        int Capacity = 8;
        System.out.println(maxProfit(0,wt,val,Capacity));
    }
}
