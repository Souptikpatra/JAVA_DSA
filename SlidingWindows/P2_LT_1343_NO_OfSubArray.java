package SlidingWindows;

public class P2_LT_1343_NO_OfSubArray {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0, j = k - 1, counter = 0, sum = 0;

        // Calculate the sum of the first window
        for (int l = i; l <= j; l++) {
            sum += arr[l];
        }

        // Check if the first window meets the threshold
        if (sum / k >= threshold) counter++;

        // Slide the window
        i++;
        j++;
        while (j < arr.length) {
            sum = sum - arr[i - 1] + arr[j]; // Update sum for the new window
            if (sum / k >= threshold) counter++; // Check threshold
            i++;
            j++;
        }

        return counter; // Return the count of valid subarrays
    }
}
