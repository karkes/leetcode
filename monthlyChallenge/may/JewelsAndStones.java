/*
*
*  We can store a freq map of Stones string.
*  Scanning the Jewels string and looking up the freq map
*  will return the count of Jewels in single pass.
*  Time : O(J + S)
*  Space : O(1)
*
*/
class Solution {
  
    public int numJewelsInStones(String J, String S) {
        
        if (J.isEmpty() || S.isEmpty()) {
            return 0;
        }
        
        int[] freq = new int[256];
        int res = 0;
        
        for (int i = 0; i < S.length(); i++) {
            freq[S.charAt(i)]++;
        }
        
        for (int i = 0; i < J.length(); i++) {
            res += freq[J.charAt(i)];
        }
        
        return res;
        
    }
}
