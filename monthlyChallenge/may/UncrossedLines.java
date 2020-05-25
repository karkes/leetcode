/*
*
*  Problem is lcs
*
*  Time : O(n *m)
*  Space : O(n * m)
*
*/
class Solution {
  
    public int maxUncrossedLines(int[] A, int[] B) {
        
        if (A.length == 0 || B.length == 0) return 0;
        
        // top down DP - memoization
        
        /* int[][] dp = new int[A.length][B.length];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                dp[i][j] = -1;
            }
        }
        
        return lcs(A, B, 0, 0, dp); */
        
        // bottom up DP
        
        int[][] dp = new int[A.length + 1][B.length + 1];
        
        for (int i = 1; i <= A.length; i++) {
            
            for (int j = 1; j <= B.length; j++) {
                
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return dp[A.length][B.length];
        
    }
    
    public int lcs(int[] A, int[] B, int i, int j, int[][] dp) {
        
        if (i == A.length || j == B.length) 
            return 0;
        
        if (dp[i][j] != -1) 
            return dp[i][j];
        
        if (A[i] == B[j]) 
            return dp[i][j] = 1 + lcs(A, B, i + 1, j + 1, dp);
        
        return dp[i][j] = Math.max(lcs(A, B, i + 1, j, dp), lcs(A, B, i, j + 1, dp));
    }
}
