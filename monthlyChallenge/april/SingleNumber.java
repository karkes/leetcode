class Solution {
    public int singleNumber(int[] nums) {
        
        /* HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return -1; */
        
        // w/o extra space
        int res = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            res ^= nums[i];
        }
        return res;
    }
}