/*
* 
*  Trick to find majority element in one scan is to cancel elements that are different.
*  By keeping track of count and updating res that's what we're doing.
* 
*  The majority element exists in the array for sure so we can return the element directly 
*  without validating the count of our candidate.
*  Time : O(n)
*  Space : O(1)
*
*/
class Solution {
    public int majorityElement(int[] nums) {
        
        if(nums.length==1)
            return nums[0];
        
        // Arrays.sort(nums); 
        // return nums[nums.length/2];
    
        // Moore's Voting algorithm
        int res=0;
        int count=0;
        
        for (int n : nums) {
            
            if (count == 0) {
                count = 1;
                res = n;
            }
            else {
                
                if (n == res) {
                    count++;
                }
                else {
                    count--;
                }
            }
        }
        // since we know majority element always exists no need to verify our candidate
        return res;
        
    }
}
