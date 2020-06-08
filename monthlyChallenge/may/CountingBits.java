/*
*
*    Intuition : use previous soln to get answer - DP bottum up manner
*    0 - 0000     Observ : if you take two numbers e.g. 6 and 5
*    1 - 0001              the binary part to the left of LS 1 of 6 is same in 5 and 6
*    2 - 0010              the binary part to the right of the LS 1 in 6 will contain all 1's in 5
*    3 - 0011              this is true for any n and n - 1. A better example is :
*    4 - 0100              64 - 00..01 00 00 00 
*    5 - 0101              63 - 00..00 11 11 11
*    6 - 0110              on ANDing common part to the left of LS 1 is retained
*    7 - 0111              Another obs is any even no will always only have powers of 2 set
*    8 - 1000              e.g. 10 - 1010, to make it odd always the first bit has to be made one
*    9 - 1001                   11 - 1011, (regular parity check n & 1 == 1 -> n is Odd)
*    10- 1010              Method #1
*    11- 1011              # of 1's in n = #1s in n & (n - 1) + 1(to count LS 1 of n lost in ANDing)
*    12- 1100              
*                          If we right shift(divide by 2) >> a num by 1, #1s will be same except in odd numbers
*    Time : O(n)           4 and 2; 6 and 3; 10 and 5 have equal # 1's since LSB is always 0
*    Space : O(1)          7 and 3; 9 and 4; 11 and 5 will lose a 1 on LSB so add + 1
*                          Method #2 
*                          # of 1's in n = # of 1's in n / 2 + 1(if n is odd)
*
*/
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        
        /* for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i-1)] + 1;
        } */
        
        for (int i = 1; i <= num; i++) {
            res[i] = res[i / 2] + (i % 2);
        }
        
        return res;
    }
}
