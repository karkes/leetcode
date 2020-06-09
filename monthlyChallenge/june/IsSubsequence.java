/*
*  
*  Follow up when k >= 1B ; 
*                 0 <= s.length <= 100; 
*                 0 <= t.length <= 10^4; s << t << k 
*  Simple method -
*  1. linear scan of t will give time complexity O(k * t) ~ large
*  
*  2. to process k incoming strings one by one so we've to atleast look all incoming chars in s
*     and run them against t i.e k * s * t (checking each char of s in t)
*  Since we're looking at index in t in inc order, Binary Search is possible
*  
*  O(s * log(freq of ch)) for each S => O(k * s * log(c)) where s and c are small
*  Note : for more accurate time taken by binary search : loga+logb=log(ab); where a and b are resp. frequency
*         however overall value will still be very small

*  Eg-1. s="abc", t="bahbgdca"
*        t(idx)=[a={1,7}, b={0,3}, c={6}]
*        s(i=0) ('a'): prev=1
*        s(i=1) ('b'): prev=3
*        s(i=2) ('c'): prev=6 (return true)
*  Eg-2. s="abc", t="bahgdcb"
*        t(idx)=[a={1}, b={0,6}, c={5}]
*        s(i=0) ('a'): prev=1
*        s(i=1) ('b'): prev=6
*        s(i=2) ('c'): prev=? (return false)
*
*  To prepare char freq map of t we will process it which will take O(t)
*
*  Time : O(t + (k * s * log(c))) ~ O(k * s * log(c))
*
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        
        // Scaning String t; Time : O(t)
        /* if (s.length() == 0) return true;
        
        int j = 0;
        
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
                if (j == s.length()) return true;
            }
        }
        
        return false;
        
        // Scaning String s; Time : O(s * t)
        int idx = -1;
        for (char ch : s.toCharArray()) {
            idx = t.indexOf(ch, idx + 1);
            if (idx == -1) return false;
        }
        return true; */
        
        
        // return isSubsequence(s, t, 0, 0);
        
        return isSubsequenceK(s, t);
        
    }
    
    public boolean isSubsequenceK(String s, String t) {
        
        List<Integer>[] freq = new List[256];
        int prev = 0;
        
        for (int i = 0; i < t.length(); i++) {
            if (freq[(t.charAt(i))] == null) {
                freq[(t.charAt(i))] = new ArrayList<>();
            }
            freq[(t.charAt(i))].add(i);
        }
        
        
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == null) {
                return false;
            }
            // If key is not present, returns "(-(insertion point) - 1)
            int idx = Collections.binarySearch(freq[s.charAt(i)], prev);
            if (idx < 0) { // key not found
                idx = -idx -1; // insertion point
            }
            if (freq[s.charAt(i)].size() == idx) {  // key is greater than all elements of list
                return false;
            }
            prev = freq[s.charAt(i)].get(idx) + 1; // next index to be searched
        }
        return true;
    }
    
    public boolean isSubsequence(String s, String t, int i, int j) {
        if (i == s.length()) {
            return true;
        }
        if (j == t.length()) {
            return false;
        }
        if (s.charAt(i) == t.charAt(j)) {
            return isSubsequence(s, t, i + 1, j + 1);
        }   
        return isSubsequence(s, t, i, j + 1);
    }
}
