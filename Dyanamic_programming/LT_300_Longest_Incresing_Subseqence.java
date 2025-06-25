package Dyanamic_programming;
import java.util.ArrayList;
public class LT_300_Longest_Incresing_Subseqence {
    public int findMax(int[] arr) { // to find the maximum element in an array
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            temp = Math.max(arr[i], temp);
        }
        return temp;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] will store the length of LIS ending at index i

        dp[0] = 1; // For the first element, LIS is always 1

        for (int i = 1; i < n; i++) {
            int currMax = 0; // Store the maximum LIS length found so far for nums[i]
            for (int j = i - 1; j >= 0; j--) {
                int currElement = nums[i];
                if (nums[j] >= currElement) continue; // Only consider increasing elements
                currMax = Math.max(currMax, dp[j]); // Update currMax with the best previous subsequence
            }
            dp[i] = currMax + 1; // Add current element to the best previous subsequence
        }

        return findMax(dp); // The maximum value in dp[] is the length of the LIS
    }

}
