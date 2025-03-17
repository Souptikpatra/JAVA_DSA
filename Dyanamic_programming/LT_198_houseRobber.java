package Dyanamic_programming;

import java.util.HashMap;

public class LT_198_houseRobber {
    // non memoization
//    public int amount(int[] num, int i){
//        // if robber stands at last index/or more, then there is no hope to get money from next house,  as there was no next house
//        if(i >= num.length) return 0;
//        int take = num[i] + amount(num,i+2); // if took then don't go to adjacent house, directly go next to the adjacent house
//        int skip = amount(num,i+1);
//        return Math.max(take,skip);
//    }
//    public int robb(int[] nums) {
//        // i --> current index where robber stands
//        return amount(nums,0); // initially robber is at oth index
//    }

    // memoization

    HashMap<Integer,Integer> memo = new HashMap<>(); // (key,value) = (i, result)
    public int amount(int[] nums, int i){
        // if robber stands at last index/or more, then there is no hope to get money from next house, as there was no next house
        if(i >= nums.length) return 0;
        int take;
        if(memo.containsKey(i+2)) take = nums[i]+ memo.get(i+2);
        else{
            int result = amount(nums,i+2); // if took then don't go to adjacent house, directly go next to the adjacent house
            take = nums[i] + result;
            memo.put(i+2, result);
        }

        int skip;
        if (memo.containsKey(i+1)) skip = memo.get(i+1);
        else {
            int result = amount(nums,i+1);
            skip = result;
            memo.put(i+1,result);
        }
        return Math.max(take,skip);
    }
    public int rob(int[] nums) {
        // i --> current index where robber stands
        return amount(nums,0); // initially robber is at 0th index
    }


    // Tabulation

//    public int rob(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0]; dp[1] = Math.max(nums[0],nums[1]);
//        for (int i = 2; i < n; i++) {
//            dp[i] = Math.max((nums[i] + dp[i-2]),(dp[i-1]));
//        }
//        return Math.max(dp[n-1],dp[n-2]);
//    }









    public static void main(String[] args) {

    }

}
