class Solution {
    public void reverseString(char[] s) {
        int i, j;
        for (i = 0, j = s.length - 1; i < j; i++, j--) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }
    }
}
