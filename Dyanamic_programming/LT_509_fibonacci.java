package Dyanamic_programming;
import java.util.ArrayList;
import java.util.HashMap;

class fibo{
    HashMap<Integer, Integer> hm = new HashMap<>(); // Map to store previously computed Fibonacci result
    public int fib_recur(int n) {
        if (n == 0 || n == 1) return n; // Base cases: fib(0) = 0, fib(1) = 1

        if (hm.containsKey(n)) // Check if result for fib(n) is already computed
            return hm.get(n);  // Return cached result to avoid redundant computation

        int ans = fib_recur(n - 1) + fib_recur(n - 2); // Recursive computation of fib(n)
        hm.put(n, ans); // Store the computed result in the map for future use

        return ans; // Return the result for fib(n)
    }

    // Tabulation
    int fib_iterative(int n){
        if (n <= 1) return n; // base case
        int [] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1; // initial filling to array
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
public class LT_509_fibonacci {
    public static void main(String[] args) {
        fibo fb = new fibo();
        System.out.println(fb.fib_iterative(3));
    }
}
