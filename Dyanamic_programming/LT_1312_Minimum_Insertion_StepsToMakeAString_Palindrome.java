package Dyanamic_programming;

public class LT_1312_Minimum_Insertion_StepsToMakeAString_Palindrome {
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

    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}
