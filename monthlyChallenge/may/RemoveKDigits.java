class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) return "0";
        int resDigit = len - k;
        int start = 0;
        int end = k;
        StringBuilder res = new StringBuilder();
        while (resDigit > 0) {
            resDigit--;
            int[] min = minDigit(num, start, end);
            res.append(min[0]);
            start = min[1] + 1;
            end++;
        }
        int leadingZero = 0;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '0') leadingZero++;
            else break;
        }
        res.replace(0, leadingZero, "");
        String minNum = res.toString();
        return minNum.equals("") ? "0" : minNum; 
    }
    
    public int[] minDigit(String num, int start, int end) {
        int min = 10;
        int idx = -1;
        for (int i = start; i <= end; i++) {
            int digit = num.charAt(i) - '0';
            if (digit < min) {
                min = digit;
                idx = i;
            }
                
            if (min == 0) break;
        }
        return new int[] {min, idx};
    }
}
/*
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        
        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            if (sb.length() > 0 || c != '0') sb.append(c);
        }
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        return sb.length() == 0? "0" : sb.toString();
    }
} 
*/
