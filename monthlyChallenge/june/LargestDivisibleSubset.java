// TODO : Fix second method

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        /* Time : O(n * n)
           Space : O(n * n) if most numbers are co-prime then O(n)
        int n = nums.length;
        if (n < 1) {
            return new ArrayList<Integer>();
        }
        Arrays.sort(nums);
        List<Integer>[] subset = new ArrayList[n];
        int maxSubsetLen = 0;
        int maxSubsetIdx = 0;
        for (int i = n - 1; i >= 0; i--) {
            subset[i] = new ArrayList<>();
            subset[i].add(nums[i]);
            int j = n - 1;
            int maxlen = 0;
            int maxIdx = -1;
            while (j > i) {
                
                if (nums[j] % nums[i] == 0) {
                    if (subset[j].size() > maxlen) {
                        maxlen = subset[j].size();
                        maxIdx = j;
                    }
                }
                j--;
            }
            if (maxIdx > 0) subset[i].addAll(subset[maxIdx]);
            if (subset[i].size() > maxSubsetLen) {
                maxSubsetLen = subset[i].size();
                maxSubsetIdx = i;
            }
        }
        return subset[maxSubsetIdx]; */
        
        // with O(n) extra space; by maintaining pointer to next subset element
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n < 1) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> largstSubset = new ArrayList<>();
        int[] subsetPtr = new int[n];
        Arrays.fill(subsetPtr, -1);
        int maxSubsetLen = 0;
        int maxSubsetIdx = 0;
        for (int i = n - 1; i >= 0; i--) {
        
            int j = n - 1;
            int maxlen = 0;
            int count = 0;
            subsetPtr[i] = i;
            while (j > i) {
                
                if (nums[j] % nums[i] == 0) {
                    count++;
                    if (count > maxlen) {
                        maxlen = count;
                    }
                    subsetPtr[i] = j;
                }
                j--;
            }
            
            if (count > maxSubsetLen) {
                maxSubsetLen = count;
                maxSubsetIdx = i;
            }
        }
        res.add(nums[maxSubsetIdx]);
        while (subsetPtr[maxSubsetIdx] != maxSubsetIdx) {
            res.add(nums[subsetPtr[maxSubsetIdx]]);
            maxSubsetIdx = subsetPtr[maxSubsetIdx];
        }
        return res;
        
    }
}
