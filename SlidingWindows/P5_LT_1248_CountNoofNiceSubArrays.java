package SlidingWindows;

public class P5_LT_1248_CountNoofNiceSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        // Convert the array: odd numbers -> 1, even numbers -> 0
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }

        int n = nums.length;
        int i = 0, j = 0, a = 0, b = 0, count = 0, k2 = 0;

        // Position i at the first odd number
        while (i < n && nums[i] == 0) i++;

        // Position j to include exactly k odd numbers
        while (j < n && k2 < k) {
            if (nums[j] == 1) k2++;
            j++;
        }
        if (k2 < k) return 0; // Not enough odd numbers
        j--; // Adjust j to the correct position

        // Position b just before the next odd number after j
        b = j + 1;
        while (b < n && nums[b] == 0) b++;
        b--;

        // Sliding window to calculate valid subarrays
        while (b < n) {
            // Count subarrays using lengths from a->i and j->b
            count += (i - a + 1) * (b - j + 1);

            // Move a and i to the next odd number
            a = i + 1;
            i++;
            while (i < n && nums[i] == 0) i++;

            // Move j and b to the next odd number after the current b
            j = b + 1;
            b = j + 1;
            while (b < n && nums[b] == 0) b++;
            b--;
        }
        return count;
    }

}
