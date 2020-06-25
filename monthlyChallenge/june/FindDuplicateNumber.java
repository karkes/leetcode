/*
*
*  Q- https://leetcode.com/problems/find-the-duplicate-number/
*
*  sum approach won't work here since we can have multiple repetition of a number
*  try to sort and look for adjacent..but we can't modify the array
*  since index will always exist within the array because of the constraint
*  trick : try tortoise hare algo here
*  Time : O(n)
*  Space : O(1)
*
*/
class Solution {
    public int findDuplicate(int[] nums) {
        /* HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                //found duplicate
                return i;
            }else{
                set.add(i);
            }
        }
        return 0; */
        
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
            
        }while(slow != fast);
        
        int ptr1 = nums[0];
        int ptr2 = slow;
            
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
