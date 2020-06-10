/*
*
*  Intuition : Std. Binary Search 
*  We've to return index of next greater num when target is not present
*  if element is not present l and h pointers will be equal before they overlap
*  2 cases are possible before the search stops :
*
*  low == high == mid => nums[mid] = val < target => low = mid + 1 => exit
*
*  low == high == mid => nums[mid] = val > target => high = mid - 1 => exit
*
*  both cases l is pointing to the insertion spot, so return l
* 
*  Time : O(logn)
*  Space : O(1)
*
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        // returns -(insertion point) - 1 if target not found
        // returns index if target found
        /* int idx = Arrays.binarySearch(nums, target);
        if (idx < 0) {
            idx = -idx - 1;
        }
        return idx; */
        
        return myBinarySearch(nums, target);
    }
    
    public int myBinarySearch(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) return mid;
            
            else if (nums[mid] < target) l = mid + 1;
            
            else h = mid - 1;
        }
        return l;
    }
}
