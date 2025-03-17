package Dyanamic_programming;

import java.util.HashMap;

public class LT_279_PerfectSquare {

//     // raw recursion
//    public static int[] getLeastSquares(int n){ // this finds all perfect square before `n`.
//        int sqrtOf_n = (int)Math.sqrt(n);
//        int t = sqrtOf_n; // t holds decreasing values from sqrt(n) down to 1
//        int [] leastSquares = new int[sqrtOf_n];
//        for (int i = 0; i < sqrtOf_n; i++) {   // T.C = O(root(n))
//            leastSquares[i] = t * t;
//            t--;
//        }
//        return leastSquares;
//    }
//    public static boolean isPerfect(int n){ // checks `n` is perfect Square or not
//        int sqrtOf_n = (int)Math.sqrt(n);
//        if (sqrtOf_n*sqrtOf_n == n) return true;
//        else return false;
//    }
//
//    public static int numSquares(int n) {
//        if (isPerfect(n)) return 1; // if `n` is already perfect then min length 1, EX: 49 --> 49 [length = 1]
//        int[] leastSquare = getLeastSquares(n); // leastSquare stores all perfect square that comes before `n`
//        int minLength = Integer.MAX_VALUE;
//        for (int i = 0; i < leastSquare.length; i++) {
//            int currLength = 1 + numSquares(n-leastSquare[i]);
//            if (currLength < minLength) minLength = currLength;
//        }
//        return minLength;
//    }

    // memoization implemented
    public  int[] getLeastSquares(int n){
        int sqrtOf_n = (int)Math.sqrt(n);
        int t = sqrtOf_n; // t holds decreasing values from sqrt(n) down to 1
        int [] leastSquares = new int[sqrtOf_n];
        for (int i = 0; i < sqrtOf_n; i++) {   // T.C = O(root(n))
            leastSquares[i] = t * t;
            t--;
        }
        return leastSquares;
    }

    public  boolean isPerfect(int n){
        int sqrtOf_n = (int)Math.sqrt(n);
        if (sqrtOf_n*sqrtOf_n == n) return true;
        else return false;
    }

    HashMap<Integer,Integer> memo = new HashMap<>();

    public  int numSquares(int n) {
        if (isPerfect(n)) return 1;
        int[] leastSquare = getLeastSquares(n);
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < leastSquare.length; i++) {
            // check memo
            int remaining;
            if (memo.containsKey(n-leastSquare[i])) remaining = memo.get(n-leastSquare[i]);
            else {
                remaining = numSquares(n-leastSquare[i]);
                memo.put((n-leastSquare[i]),remaining);
            }
            int currLength = 1 + remaining;
            if (currLength < minLength) minLength = currLength;
        }
        return minLength;
    }






    public static void main(String[] args) {
        
    }
}
