/*
*
*  Detect if the graph has cycle?
*  If Yes then not possible to complete all courses, Else possible
*
*  Time : O(E + V)
*  Space : O(E + V)
*
*/
class Solution {
    
    private ArrayList<Integer>[] adj;
    private boolean[] visitd;
    private boolean[] explrd;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        visitd = new boolean[numCourses];
        explrd = new boolean[numCourses];
        adj = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] prereq : prerequisites) {
            adj[prereq[0]].add(prereq[1]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!visitd[i] && cycleExistDFS(i)) {
                return false;
            }
        } 
        return true;
    }
    
    public boolean cycleExistDFS(int v) {
        
        if (visitd[v] && !explrd[v]) return true;
        if (visitd[v] && explrd[v]) return false;
        
        visitd[v] = true;
        for (Integer neigh : adj[v]) {
            if (cycleExistDFS(neigh))
                return true;
        }
        explrd[v] = true;
        return false;
    }
}
