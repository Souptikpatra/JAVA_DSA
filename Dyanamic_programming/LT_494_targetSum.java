package Dyanamic_programming;

public class LT_494_targetSum {

     // pure recursion

        int ans = 0; // To store the total number of valid ways

        // Recursive function to explore all '+' and '-' combinations
        public void ways(int i, int[] nums, int target, int currentSum) {
            // Base case: if we have used all numbers
            if (i == nums.length) {
                // If the sum matches the target, increment answer
                if (currentSum == target) {
                    ans += 1;
                }
            }

            else {
                // Try adding the current number
                ways(i + 1, nums, target, currentSum + nums[i]);
                // Try subtracting the current number
                ways(i + 1, nums, target, currentSum - nums[i]);
            }
        }

        // Main function to start recursion
        public int findTargetSumWays(int[] nums, int target) {
            ways(0, nums, target, 0); // Start from index 0 with initial sum = 0
            return ans; // Return total ways found
        }






    public static void main(String[] args) {

    }
}
