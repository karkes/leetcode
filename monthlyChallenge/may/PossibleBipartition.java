/*
*
*  Bipartite graph has no edges btw nodes in same group.
*  Observations : 
*  A graph which has no cycle is bipartite
*  A graph which has even #node cycle is bipartite
*  So, only a graph with odd #node cycle is not bipartite
*  Bipartite graph will have chromatic number = 2 by def. 
*  hence, vertex are in two groups of different colors say 0 and 1
*
*  We need to construct the adj list because simply traversing the list in given order doesn't guarantee DFS.
*  e.g. 1(color - 0)-2(color - 1) ... 4(color - 0)-5(color - 1) or  4(color - 1)-5(color - 0)
*  one might give answer as true and other as false depending on the order input is processed.
*  Time : O(E + V)
*  Space : O(E + V)
*
*  Union find solution also exist ?!
*
*/
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        
        ArrayList<Integer>[] adjList = new ArrayList[N];
        int[] color = new int[N];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < N; i++) 
            adjList[i] = new ArrayList<>();
        
        for (int[] edge : dislikes) {
            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);
        }
        
        // run DFS in loop since graph can have disconnected components
        for (int i = 0; i < N; i++) {
            if (color[i] == -1 && !dfs(adjList, color, 0, i)) 
                return false;
        }
        
        return true;
    }
    
    public boolean dfs(ArrayList<Integer>[] adjList, int[] color, int thisColor, int vertex) {
        if (color[vertex] != -1) {
            return color[vertex] == thisColor;
        }
        color[vertex] = thisColor;
        for (int neigh : adjList[vertex]) {
            if (!dfs(adjList, color, thisColor ^ 1, neigh))
                return false;
        }
        return true;
    }
    
    /* code from other's submission
    UF -
      public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N+1];
        for (int i = 1; i<= N; i++) color[i] = i;
        for (int[] dislike : dislikes) {
            int color1 = dislike[0], color2 = dislike[1];
            if (color[color2] == color2) color[color2] = color1;
            else {
                int[] par1 = find(color, color1), par2 = find(color, color2);
                if (par1[0] == par2[0] && par1[1] == par2[1]) return false;
            }
        }
        return true;
    }
    int[] find(int[] colors, int x) {
        int color = 0;
        while (x != colors[x]) {
            x = colors[x];
            color = color == 0 ? 1 : 0;
        }
        return new int[]{x, color};
    }
    
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] group = new int[N+1];
        for (int i = 0; i <= N; i++) {
            group[i] = i; // initial
        }
        
        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            
            if (group[a] == a && group[b] == b) {
                group[a] = b;
                group[b] = a;
            } else if (group[a] == a && group[b] != b) {
                // let a go to group that all hate b;
                group[a] = group[group[b]];
            } else if (group[b] ==b && group[a] != a) {
                group[b] = group[group[a]];
            } else if (group[b] == group[a]) {
                return false;
            }
        }
        return true;        
    }
    
    
    */
}
