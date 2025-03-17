package SlidingWindows;
public class P1_maxSum_ofSubarray_ofsizeK {
    public static int maxSum(int[] arr, int k) {
        // Initialize window indices
        int i = 0; // starting index of window
        int j = k - 1; // ending index of window

        int subArraySum = 0;

        // Calculate the sum of the first window (O(k))
        for (int l = i; l <= j; l++) {
            subArraySum += arr[l];
        }

        int maxSum = subArraySum;  // Initialize maxSum with the first window's sum
        i++;j++; // slide the window

        while (j < arr.length) {
            subArraySum = subArraySum - arr[i - 1] + arr[j]; // Update window sum
            maxSum = Math.max(maxSum, subArraySum);         // Update maxSum if needed
            i++;j++; // move to the next window
        }
        return maxSum; // Return the maximum sum found
    }

    public static void main(String[] args) {
        int[] arr = {10,20,1,3,40,80,4};
        int k = 3;

        System.out.println(maxSum(arr,k));
    }
}
