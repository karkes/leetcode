/*
*  
*  Using Prefix sum we're keeping track of previous sum that appeared in the array
*  Key observation :
*  Subarray sum [L, R] = PrefixSum(R) - PrefixSum(L - 1)
*
*  We can also use 1D arrays instead of hashmap here 
*  since values are 0 or 1 so the sum can't > 2 * nums.length
*
*  Time : O(n)
*  Space : O(n)
*
*/
class Solution {
    public int findMaxLength(int[] nums) {
        
        int res = 0;
        int pref = 0;
        HashMap<Integer, Integer> firstOccMap = new HashMap<>();
        firstOccMap.put(0, -1); // if the sum starts from 0th index
        
        for (int i = 0; i < nums.length; i++) {
            pref += (nums[i] == 0) ? -1 : 1;
            Integer prefSumidx = firstOccMap.get(pref);
            if (prefSumidx != null) {
                res = Math.max(res, i - prefSumidx);
            }
            else {
                firstOccMap.put(pref, i);
            }
        }
        
        return res;
    }
    
    /*
    code from other's submission
    public int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }
    */
}
