/* REDO this question
* visited array will not work here
node 2 didn't give soln first time(longer path) but when processed again found a flight
5
[[0,1,1],[0,2,5],[1,2,1],[2,3,1],[3,4,1]]
0
4
2
*/
class Solution {
    
    private class Node implements Comparable<Node> {
        
        int v;
        int cost;
        int stops;
        // k stops = k + 1 edges e.g a -> b -> c
        public Node(int vrtx, int cst, int stps) {
            v = vrtx;
            cost = cst;
            stops = stps;
        }
        
        public int compareTo(Node that) {
            return this.cost - that.cost;
        }
        
        public String toString() {
            return "vertex : " + v + ", cost : " + cost + "|";
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    
        List<Node>[] adj = new ArrayList[n];
        for (int[] flight : flights) {
            // [src, dest, weight]
            int sourc = flight[0];
            int dest = flight[1];
            int weight = flight[2];
            if (adj[sourc] == null) {
                adj[sourc] = new ArrayList<Node>();
            }
            Node node = new Node(dest, weight, 0);
            adj[sourc].add(node);
        }
        //boolean[] visit = new boolean[n];
        Queue<Node> minHeap = new PriorityQueue<>();
        
        minHeap.add(new Node(src, 0, 0));
        
        while (!minHeap.isEmpty()) {
            
            Node node = minHeap.poll();
            //visit[node.v] = true;
            
            if (node.v == dst) 
                return node.cost;
            
            if (adj[node.v] != null && node.stops < K + 1) {
                 
                for (Node neigh : adj[node.v]) {
                    
                    //if (!visit[neigh.v]) {
                            
                        minHeap.add(new Node(neigh.v, node.cost + neigh.cost, node.stops + 1));
                    //}
                }
            }
        }        
        
        return -1;
    }
    
}
