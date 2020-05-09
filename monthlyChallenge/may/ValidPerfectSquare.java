class Solution {
    public boolean isPerfectSquare(int num) {
        
        int unitDigit = num % 10;
        
        if (unitDigit == 2 || unitDigit == 3 || unitDigit == 7 || unitDigit == 8)
            return false;
        
        long low = 1;
        long high = num;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (mid * mid < num) {
                low = mid + 1;
            }
            else if (mid * mid > num) {
                high = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
