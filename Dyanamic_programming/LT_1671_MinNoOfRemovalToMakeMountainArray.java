package Dyanamic_programming;

public class LT_1671_MinNoOfRemovalToMakeMountainArray {

    public int minimumMountainRemovals(int[] nums) {
       int[] dp1 = new int[nums.length];
       int[] dp2 = new int[nums.length];

       // filling dp1
        dp1[0] = 1; // For the first element, LIS is always 1
        for (int i = 1; i < nums.length; i++) {
            int currMax = 0; // Store the maximum LIS length found so far for nums[i]
            for (int j = i - 1; j >= 0; j--) {
                int currElement = nums[i];
                if (nums[j] >= currElement) continue; // Only consider increasing elements
                currMax = Math.max(currMax, dp1[j]); // Update currMax with the best previous subsequence
            }
            dp1[i] = currMax + 1; // Add current element to the best previous subsequence
        }

        // filling dp2
        dp2[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            int currMax = 0; // Store the maximum LIS length found so far for nums[i]
            for (int j = i + 1; j < nums.length; j++) {
                int currElement = nums[i];
                if (nums[j] >= currElement) continue; // Only consider increasing elements
                currMax = Math.max(currMax, dp2[j]); // Update currMax with the best previous subsequence
            }
            dp2[i] = currMax + 1; // Add current element to the best previous subsequence
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = dp1[i] + dp2[i] - 1;
            res = Math.max(res,temp);
        }
        return nums.length- res;
    }





}
