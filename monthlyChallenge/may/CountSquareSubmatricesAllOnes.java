/*
*
*  Using bottom up DP approach
*  Try this link for intuition : https://www.youtube.com/watch?v=oPrpoVdRLtg
*  Possible to optimize space by taking 1D array for a column currently solving.
*
*  Time : O(n*n)
*  Space : O(n*n)
*
*/
class Solution {
    public int countSquares(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        int total = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                }
                else if(matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                total += dp[i][j];
            }
        }
        return total;
        
    }
}
