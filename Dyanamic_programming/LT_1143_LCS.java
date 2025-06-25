package Dyanamic_programming;
public class LT_1143_LCS {
    // pure recursion
//    public static int helper(String text1, String text2, int idx1, int idx2){
//        int length = 0;
//        if (idx1  == -1 || idx2 == -1) return length;
//
//        if(text1.charAt(idx1) == text2.charAt(idx2)) {
//            length = 1 + helper(text1,text2, idx1 -1, idx2 -1);
//        }
//        else {
//            length = Math.max(helper(text1,text2, idx1, idx2 -1) , helper(text1,text2, idx1 -1, idx2));
//        }
//        return length;
//
//    }
//
//    public static int longestCommonSubsequence(String text1, String text2) {
//        int idx1 = text1.length() - 1;
//        int idx2 = text2.length() - 1;
//        return helper(text1,text2,idx1,idx2);
//    }

    // memoized

    static int memo[][];
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


    // Tabulation  --> conversion method

    public static int longestCommonSubsequence_tabulation(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        memo = new int[m][n]; //  i -> (m-1) - 0  || j -> (n-1) -> 0
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                int p = (i == 0 || j == 0) ? 0 : memo[i-1][j-1];
                int q = (j== 0) ? 0 : memo[i][j-1];
                int r = (i == 0) ? 0 :  memo[i -1][j];
                if(text1.charAt(i) == text2.charAt(j)) {
                    memo[i][j] = 1 + p;
                }
                else {
                    memo[i][j] = Math.max(q ,r);
                }
            }
        }
        return memo[m-1][n-1]; // return the last element
    }



    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
        System.out.println(longestCommonSubsequence("aggtab", "gxtxayb"));
    }
}
