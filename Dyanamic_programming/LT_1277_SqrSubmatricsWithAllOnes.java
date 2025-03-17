package Dyanamic_programming;
public class LT_1277_SqrSubmatricsWithAllOnes {
    public static int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                if(i == 0 || j == 0) { // if (top-row) & (left-col) then there is no '1' that can be a bottom-right corner of a square except himself (1x1) square
                    dp[i][j] = matrix[i][j];
                }
                else if (matrix[i][j] == 1) { // main logic
                    dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        int count = 0; // count gonna store the result
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                count += dp[i][j]; // traversing 'dp' array to get 'count'
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr ={{0,1,1,1},
                      {1,1,1,1},
                      {0,1,1,1}};
        System.out.println(countSquares(arr));
    }
}
