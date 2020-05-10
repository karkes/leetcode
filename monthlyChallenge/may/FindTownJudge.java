/*
*
*  We've to maintain count of trust while scaning input array. 
*  We can use either HashMap or arrays to store the count.
*  To check the result is correct make sure that judge doesn't trust another person.
*
*  Alt : we can also use two arrays inEdges and outEdges to maintain the relationship of input array.
*        for(int[] relation :trust)
*            outEdges[relation[0]]++;
*            inEdges[relation[1]]++;
*        then check this condition in these arrays 
*        for (int i = 1; i <= N; i++)
*            if (inEdges[i] == N - 1 && outEdges[i] == 0)
*                return i;
*  
*  Time : O(n)
*  Space : O(n)
*
*/
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if (N < 2)
            return 1;
        
        int maxTrust = -1;
        int judge = 1;
        int[] candCount = new int[N + 1];
        
        for (int i = 0; i < trust.length; i++) {
            candCount[trust[i][1]]++;
            if (candCount[trust[i][1]] > maxTrust) {
                maxTrust = candCount[trust[i][1]];
                judge = trust[i][1];
            }
        }
        
        if (maxTrust != N - 1) return -1;
        
        for (int[] pair : trust) 
            if (pair[0] == judge) return -1;
        
        return judge;
    }
}
