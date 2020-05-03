/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*
*
*  This problem is a variation of standard Binary Search. 
*  Here we return the "first" occurence of item (left -> right) in the search space. 
*
*  Trick is to store item in 'res' everytime we find it and move our search space 
*  upper bound closer to low - this will continue the search and return the first 
*  position of the item in the array.
*
*/
public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        
        int low = 1;
        int high = n;
        int res = 0;
        
        while (low <= high) {
            
            int mid = low + (high - low) / 2;
            
            if (isBadVersion(mid) == true) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return res;
        
    }
}