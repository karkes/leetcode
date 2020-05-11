/*
*
*  Code is more complex if you try to do bfs - 
*  taking care of duplicates while looking at neighbors will require HashSet
*  and key for set is not direct to use like TreeNode which are already an obj ref. 
*  dfs is more elegant and natural here.
*  Time - O(n*n)
*  Space - O(n*n)
*
*/
class Solution {
    private class Position {
        int row;
        int col;
        public Position(int i, int j) {
            row = i;
            col = j;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        dfs(image, sr, sc, newColor);
        
        return image;
        
    }
    
    public void dfs(int[][] img, int i, int j, int newColor) {
        
        int currColor = img[i][j];
        img[i][j] = newColor;
        
        if (currColor == newColor) return;
        
        if (j - 1 >=0 && img[i][j - 1] == currColor) { //adj left cell
            dfs(img, i, j - 1, newColor);
        }
        if (j + 1 <= img[0].length - 1 && img[i][j + 1] == currColor) { //adj right cell
            dfs(img, i, j + 1, newColor);
        }
        if (i + 1 <= img.length - 1 && img[i + 1][j] == currColor) { //adj upper cell
            dfs(img, i + 1, j, newColor);
        }
        if (i - 1 >= 0 && img[i - 1][j] == currColor) { //adj lower cell
            dfs(img, i - 1, j, newColor);
        }
        
        return ;
    }
}
