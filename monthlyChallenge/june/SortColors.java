/*
*  Intuition : -----------|----------|-----------
*                 0s     low   1s   high  2's
*
*  Maintain 2 pointers and swap values to match above ordering.
*  Note : we are done once i pointer reaches high because beyond high all numbers are already arranged.
*
*  Time : O(n)
*  Space : O(1)
*
*/
class Solution {
    public void sortColors(int[] nums) {
        int pivot = 1;
        int low = 0;
        int high = nums.length - 1;
        
        for (int i = 0; i <= high; i++) {
            
            if (nums[i] == 0) {
                swap(i, low, nums);
                low++;
            }
            else if (nums[i] == 2) {
                swap(i, high, nums);
                i--;
                high--;
            }
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
