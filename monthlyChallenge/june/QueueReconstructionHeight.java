/*
*
*  Intuition : 
*  we have to insert an element at a place so that h, k constraint is satisfied.
*  if we insert a person of smaller height(h1) before another person(h2); h1 < h2
*  this insertion will not break the invariant
*  for people with same height e.g. (5, 2) and (5, 4)
*  (5, 2) has to come before (5, 4); other way around the invariant will break
*  because (5, 4) means 4 people with height >= 5 before this index so can't place (5, 2) after
*  which means 2 people with height >= 5 before this index.
*
*  So we can sort the given queue in decreasing order of height; if height is same then smaller k value first
*  e.g. for given input after sorting we will get : [7, 0][7, 1][6, 1][5, 0][5, 2][4, 4]
*  
*  Now we can fill our output list based on k value of each person for e.g insert -> [5, 2]
*  adding it at index 2 is correct iff 2 people before it with height >= 5, 
*  P1, P2, new insert, P3, P4, .. inserting in middle of queue will not break the invariant because new height
*  is smaller than prev added height or same height people are arranged by inc k value.
*  since we're inserting taller people first and queue construction is possible above insertion will work
*  so, the algorithm is correct.
*
*  Time : O(n * n)
*  Space : O(n)
*
*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        
        List<int[]> q = new ArrayList<>(people.length);
        
        for (int[] p : people) {
            // System.out.print("["+p[0]+", "+p[1]+"]");
            q.add(p[1], p);
        }
        
        return q.toArray(new int[q.size()][2]);
        
    }
}
