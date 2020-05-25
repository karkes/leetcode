class StockSpanner {
    
    private class StockSpan {
        int stock;
        int span;
        
        public StockSpan(int price, int sp) {
            stock = price;
            span = sp;
        }
    }
    
    private Stack<StockSpan> stck;
    
    public StockSpanner() {
        stck = new Stack<>();
    }
    
    public int next(int price) {
        int res = 1;
        
        while (!stck.isEmpty() && stck.peek().stock <= price) {
            res += stck.pop().span;
        }
        stck.push(new StockSpan(price, res));
        
        return res;
    }
}

/* class StockSpanner {
    
    private int[] stock;
    private int[] span;
    private int i;

    public StockSpanner() {
        stock = new int[10000];
        span = new int[10000];
        i = 0;
    }
    
    public int next(int price) {
        stock[i] = price;
        int j = i - 1;
        int count = 0;
        while(j >= 0 && stock[j] <= price) {
            count += span[j];
            j = j - span[j];
        }
        count++; // self
        span[i] = count;
        i++;
        return count;
    }
} */

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
