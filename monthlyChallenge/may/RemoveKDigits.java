/*
*
*  Trick is to use stack to store the min digits. 
*  LHS vals have more significance to make the num smaller.
*  Keep popping from stack to maintain digits in asc order in stack.
*
*  Refer to this for explanation
*  https://www.youtube.com/watch?v=3QJzHqNAEXs&t=779s
*
*  Time : O(n)
*  Space : O(1)
*
*/
class Solution {
    public String removeKdigits(String num, int k) {
    
        if (num.isEmpty() || num.length() == k) return "0";
        Stack<Integer> stck = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (char ch : num.toCharArray()) {
            int val = ch - '0';
            while (!stck.empty() && stck.peek() > val && k > 0) {
                stck.pop();
                k--;
            }
            if(val != 0 || !stck.empty()) {
                stck.push(val);
            }
        }
        
        while (!stck.empty() && k > 0) {
            stck.pop();
            k--;
        }
            
        while (!stck.empty()) {
            sb.append(stck.pop());
        }
        
        String res = sb.length() == 0 ? "0" : sb.reverse().toString();
        
        return res;

    }
    
}
