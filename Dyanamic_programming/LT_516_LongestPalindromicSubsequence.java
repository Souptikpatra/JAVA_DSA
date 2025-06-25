package Dyanamic_programming;

public class LT_516_LongestPalindromicSubsequence {

    // pure recursion -- method 1

//    public static int helper(String s, int i, int j){
//        if (i == j) return 1;
//        if (i > j) return 0;
//        int length = 0;
//        if (s.charAt(i) == s.charAt(j)) length = 2 + helper(s,i+1,j-1);
//        else {
//            length = Math.max(helper(s,i+1,j), helper(s,i,j-1));
//        }
//        return length;
//    }
//    public static int longestPalindromeSubseq(String s) {
//        int i = 0;
//        int j = s.length()-1;
//        return helper(s,i,j);
//    }

//-----------------------------------------------------------------------------------------------
    // memoization  --  method 1

//    static int [][]memo ;
//    public static int helper(String s, int i, int j){
//        if (i == j) return 1;
//        if (i > j) return 0;
//        // memo check
//        if (memo[i][j] != -1 ) return memo[i][j];
//
//        int length = 0;
//        if (s.charAt(i) == s.charAt(j)) length = 2 + helper(s,i+1,j-1);
//        else {
//            length = Math.max(helper(s,i+1,j), helper(s,i,j-1));
//        }
//        memo[i][j] = length; // store the value if not found
//        return length;
//    }
//    public static int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int i = 0;
//        int j = n-1;
//
//        // i -> [0 - n/2] | j -> [n/2 - 0]
//        memo = new int[n][n];
//        for (int k = 0; k < memo.length; k++) for (int l = 0; l < memo[0].length; l++) memo[k][l] = -1;
//
//        return helper(s,i,j);
//    }

// ----------------------------------------------------------------------------------------------------------------
    // method 2: find lcs of [(s) and reverse(s)]

    static int [][]memo;
    public static int helper(String text1, String text2, int idx1, int idx2){
        int length = 0;
        if (idx1  == -1 || idx2 == -1) return length;

        if (memo[idx1][idx2] != -1) return memo[idx1][idx2];

        if(text1.charAt(idx1) == text2.charAt(idx2)) {
            length = 1 + helper(text1,text2, idx1 -1, idx2 -1);
            memo[idx1][idx2] = length;
        }
        else {
            length = Math.max(helper(text1,text2, idx1, idx2 -1) , helper(text1,text2, idx1 -1, idx2));
            memo[idx1][idx2] = length;
        }
        return length;

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int idx1 = text1.length() - 1;
        int idx2 = text2.length() - 1;

        memo = new int[idx1+1][idx2+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(text1,text2,idx1,idx2);
    }

    public static int longestPalindromeSubseq(String s) {
       StringBuilder temp = new StringBuilder(s).reverse();
       String revOfs = temp.toString();
       return longestCommonSubsequence(s,revOfs);

    }
//-----------------------------------------------------------------------------------------------


    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("forgeeksskeegfor"));
    }
}


