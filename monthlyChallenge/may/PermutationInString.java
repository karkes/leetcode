/*
*
*  Sliding window problem
*
*  Time : O(n)
*  Space : O(1)
*
*/
class Solution {
    public boolean checkInclusion(String pattern, String str) {
        
        int winStart = 0;
        int[] patternFreq = new int[26];
        int[] strFreq = new int[26];
        
        for (char ch : pattern.toCharArray()) patternFreq[ch - 'a']++;
        
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            strFreq[str.charAt(winEnd) - 'a']++;
            
            if(winEnd - winStart + 1 == pattern.length()) {
                if (checkPermu(patternFreq, strFreq)) return true;
                strFreq[str.charAt(winStart) - 'a']--;
                winStart++;
            }
        }
        return false;
    }
    
    public boolean checkPermu(int[] patternFreq, int[] strFreq) {
        
        for (int i = 0; i < 26; i++) {
            if (patternFreq[i] != strFreq[i]) return false;
        }
        return true;
    }
}
