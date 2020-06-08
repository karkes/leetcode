/*
*
*    Intuition :           A number is power of 2 is it has only one set bit.
*    0 - 0000              if you take two numbers e.g. 6 and 5
*    1 - 0001              the binary part to the left of LS 1 of 6 is same in 5 and 6
*    2 - 0010              the binary part to the right of the LS 1 in 6 will contain all 1's in 5
*    3 - 0011              this is true for any n and n - 1. 
*    4 - 0100                            
*    5 - 0101              A better example is :
*    6 - 0110              64 - 00..01 00 00 00 
*    7 - 0111              63 - 00..00 11 11 11
*    8 - 1000              on ANDing common part to the left of LS 1 is retained
*    9 - 1001              if a number(> 0) is not a power of 2 n & n - 1 != 0
*    10- 1010              if a number(> 0) is power of 2 n & n - 1 = 0
*    11- 1011              note : 2^n > 0 n can be any Integer
*    12- 1100             
*                          
*    Time : O(1)           
*    Space : O(1)          
*
*/              
              

class Solution {
    public boolean isPowerOfTwo(long n) {
        // O(logn) - TLE
        /* int powerOfTwo = 1;
        while (powerOfTwo <= n) {
            if (powerOfTwo == n) return true;
            powerOfTwo <<= 1;
        }
        return false; */
    
        if (n <= 0) {
            return false; 
        }
        
        return (n & n - 1) == 0 ? true : false;
    }
}
