package Dyanamic_programming;
public class LT_64_MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue; // if (1st cell) --> skip
                else if (i == 0) { // in 1st row
                    grid[i][j] += grid[i][j-1]; // add last cell value
                }
                else if (j == 0){ // in 1st col
                    grid[i][j] += grid[i-1][j];
                }
                else { // rest of the cell
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[row-1][col-1];
    }
    public static void main(String[] args) {

    }
}
