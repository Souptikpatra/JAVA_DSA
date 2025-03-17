package SlidingWindows;
public class P3_LT_209_min_sizeSubArraySum {


    public static int minSubArrayLen(int target, int[] arr) {
        int i = 0, j = 0, sum = 0, currLen = 0, minLen = 0;

        // Step 1: Expand the initial window until sum >= target
        while (sum < target) {
            sum += arr[j];
            j++;
            if (sum < target && j == arr.length) { // test case: arr = [1,2,3,4,5] , target = 11
                                                   // test case: arr = [1,1,1,1] , target = 6
                return 0; // No valid subarray found
            }
        }
        j--; // Adjust `j` to the correct position

        // Step 2: Calculate the length of the initial window
        currLen = j - i + 1;

        // Step 3: Set the minimum length to the initial window's length
        minLen = currLen;

        // Step 4: Slide the window and minimize length
        while (j < arr.length) {
            i++; // Shrink the window from the left
            sum -= arr[i - 1]; // again calculate 'sum' for new subArray

            // Step 5: Expand the window until sum >= target
            while (sum < target) {
                j++;
                if (j == arr.length) return minLen; // Stop if end of array is reached
                sum += arr[j];
            }

            // Update the minimum length
            currLen = j - i + 1;
            minLen = Math.min(currLen, minLen);

            // If a subarray of length 1 is found, return immediately
            if (minLen == 1) return 1;   // test case : arr = [1,4,4] , target = 4
        }

        return minLen; // Return the smallest subarray length
    }

}
