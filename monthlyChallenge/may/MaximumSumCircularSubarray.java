/*
*
*  Prob has two cases :
*
*  1. when max sum is present in the middle of array 
*     apply std. Kadane's to get this result
*     or
*  2. when max sum is present in the circular part of array 
*     e.g. | 3),-1,(2,-1 | - 4; | 5),-3,(5 | - 10
*
*     circular_sum = total_sum  - min_sum (Kadane's)
*     Corner case : when all numbers in array are negative (handle separately)
*  
*  Time : O(n)
*  Space : O(1)
*
*/
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int maxMiddle = Integer.MIN_VALUE;
        int minMiddle = Integer.MAX_VALUE;
        int totSum = 0;
        int sum = 0;
        for (int v : A) {
            totSum += v;
            sum += v;
            maxMiddle = Math.max(sum, maxMiddle);
            sum = Math.max(sum, 0);
        }
        sum = 0;
        for (int v : A) {
            sum += v;
            minMiddle = Math.min(sum, minMiddle);
            sum = Math.min(sum, 0);
        }
        
        int res = totSum == minMiddle ? maxMiddle : Math.max(maxMiddle, totSum - minMiddle);
        return res;
        
    }
}
