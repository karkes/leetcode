/*
*
*  Idea is similar to two finger algorithm for sorted arrays
*  Time : O(n)
*  Space : O(1)
*
*/
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersect = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < A.length && j < B.length) {
            
            if (A[i][1] < B[j][0]) i++;
            
            else if (B[j][1] < A[i][0]) j++;
            
            else {
                
                int[] pair= new int[2];
                pair[0] = Math.max(A[i][0], B[j][0]); // start
                pair[1] = Math.min(A[i][1], B[j][1]); // end
                
                if (B[j][1] <= A[i][1]) j++;
                
                else i++;
                
                intersect.add(pair);
            }  
        }
        
        return intersect.toArray(new int[intersect.size()][2]);
    }
}
