/*
*
*  We're XORing each bit in given num with 1 to negate the num.
*
*  Keep on moving the togglebit one step through left shift(*2) 
*  e.g. ...00001 -> ..00010 -> ..00100 -> ..01000
*       (2^0 = 1 -> 2^1 = 2 -> 2^2 = 4 -> 2^3 = 8..)
*
*  Count the num of bits in num by right shifting(/2) leftmost 1 until itr == 0
*  e.g. itr = 5 -> 2 -> 1 -> 0 (break while)
*  
*  For tests : https://leetcode.com/problems/number-complement/
*
*/
class Solution {
    public int findComplement(int num) {
        int togglebit = 1;
        int itr = num;
        
        while (itr > 0) {
            num  ^= togglebit;
            togglebit <<= 1;
            itr >>= 1;
        }
        
        return num;
    }
}
