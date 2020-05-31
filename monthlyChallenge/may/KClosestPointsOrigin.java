class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
                int dista = a[0] * a[0] + a[1] * a[1];
                int distb = b[0] * b[0] + b[1] * b[1];
                return distb - dista;
            }
        );
        
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) maxHeap.remove();
        }
        
        int[][] res = new int[K][2];
        
        while (K-- > 0) { // use value of K then dec
            res[K] = maxHeap.remove();
        }
        
        return res;
    }
    
}
