class Solution {
    public boolean checkStraightLine(int[][] cod) {
        
        int n = cod.length;
    
        for (int i = 0; i < n - 2; i++) {
            
            double m1 = findSlope(cod[i], cod[i + 1]);
            double m2 = findSlope(cod[i + 1], cod[i + 2]);
            if (Double.compare(m1, m2) != 0) {
                return false;
            }
            
        }
        return true;
    }
    
    public double findSlope (int[] cod1, int[] cod2) {
        int x1 = cod1[0]; int y1 = cod1[1];
        int x2 = cod2[0]; int y2 = cod2[1];
        if (x1 == x2) {
            return Double.POSITIVE_INFINITY;
        }
        else if (y1 == y2) {
            return 0.0;
        }
        return (double) (y2 - y1) / (double) (x2 - x1);
    }
}
