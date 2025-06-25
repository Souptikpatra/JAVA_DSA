package Dyanamic_programming;
public class LT_72_editDistance {

// version 1: pure recursion
//        public static int min(int a,int b, int c){
//            return Math.min(Math.min(a,b),c);
//        }
//        public static int helper(String word1,String word2, int i, int j){
//        if (i < 0) return j+1;
//        if (j < 0) return i+1;
//        int steps = 0;
//        if (word1.charAt(i) == word2.charAt(j)){
//            steps = helper(word1, word2, i - 1, j - 1);
//        }
//        else {
//            int insert = helper(word1, word2, i, j - 1);
//            int delete = helper(word1,word2,i-1,j);
//            int replace = helper(word1, word2,i-1,j-1);
//
//            steps = 1 + min(delete,replace,insert);
//        }
//        return steps;
//    }
//    public static int minDistance(String word1, String word2) {
//        int n = word1.length(); int m = word2.length();
//        int i = n-1;
//        int j = m-1;
//        return helper(word1,word2,i,j); // i -> on word1 | j -> on word2
//    }

 // version 2: memoization

    public static int min(int a,int b, int c){
        return Math.min(Math.min(a,b),c);
    }
    static int[][] memo;
    public static int helper(String word1,String word2, int i, int j){
        if (i < 0) return j+1;
        if (j < 0) return i+1;
        int steps = 0;
        // memo check
        if (memo[i][j] != -1) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)){
            steps = helper(word1, word2, i - 1, j - 1);
        }
        else {
            int insert = helper(word1, word2, i, j - 1);
            int delete = helper(word1,word2,i-1,j);
            int replace = helper(word1, word2,i-1,j-1);

            steps = 1 + min(delete,replace,insert);
        }
        memo[i][j] = steps; // store the result
        return steps;
    }
    public static int minDistance(String word1, String word2) {
        int n = word1.length(); int m = word2.length();
        int i = n-1;
        int j = m-1;
        memo = new int[n][m];
        for (int k = 0; k < memo.length; k++) {
            for (int l = 0; l < memo[0].length; l++) {
                memo[k][l] = -1;
            }
        }
        return helper(word1,word2,i,j); // i -> on word1 | j -> on word2
    }

    public static void main(String[] args) {
        String s = "abc";


    }
}
