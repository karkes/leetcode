/*
*
*  Storing the idx of characters seen once + 1 in freq array.
*  Default values of characters not present in given string = 0.
*  Make value at char location = -1 if same char is seen again.
*   
*  After single pass least idx in freq is first unique character.
*
*/
class Solution {
    public int firstUniqChar(String s) {
        
        int[] freq = new int[26];
        char[] str = s.toCharArray();
        int uniqIdx = Integer.MAX_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            
            if (freq[str[i] - 'a'] == 0) {
                freq[str[i] - 'a'] = i + 1;
            }
            else {
                freq[str[i] - 'a'] = -1;
            }
        }
        
        for (int c : freq) {
            
            if (c > 0) {
                uniqIdx = Math.min(c - 1, uniqIdx);
            }
        }
        
        return uniqIdx == Integer.MAX_VALUE ? -1 : uniqIdx;
    }
}
