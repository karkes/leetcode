/*
*
*  Intuition : w : [2, 3, 4]
*              i :  0, 1, 2
*   cumulative w : [2, 5, 9]
*  we've to return i randomly for each call of pickIndex in a way that the randomness depends on the weight
*  of that index. 
*  Based on weight of i in w : A = [0, 0, 1, 1, 1, 2, 2, 2, 2] P(0) = 2 / len; P(1) = 3 / len; P(2) =  4 / len
*  Logically if we pick an index from A, it will take care of randomness.
*  Based on the constraints we can't store this array(worst case - 10^9) because max size allowed in Java is 10^8
*  size of A = sum[w]; pick a random index in this range using std lib method
*  then look for the index in array containing cumulative sum of given weight.
*  e.g. randIdx = 8 means idx 2 should be returned; randIdx = 3 means idx 1 should be returned
*
*  Time : O(logn)
*  Space : O(1) ignoring space taken by input array
*
*/
               
class Solution {
    
    private int[] wCumuSum;
    private int n;

    public Solution(int[] w) {
        int sum = 0;
        n = w.length;
        wCumuSum = new int[n];
        for (int i = 0; i < n; i++) {
            sum += w[i];
            wCumuSum[i] = sum;
        }
    }
    
    public int pickIndex() {
        int randIdx = (int) (wCumuSum[n - 1] * Math.random());
        /* for (int i = 0; i < n; i++) {
            if (randIdx < wCumuSum[i]) return i;
        } */
        // cumu sum array is sorted; use binary search
        int l = 0;
        int h = wCumuSum.length - 1;
        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (randIdx < wCumuSum[m]) {
                res = m;
                h = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
