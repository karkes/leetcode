/*
*  
*  Day #3
*  Intuition: To find optimal soln we have to see what could be the max cost incurred 
*  if a candidate is sent to a wrong city and try to avoid it. e.g. :
*  [[400,50] -> Diff : 350, [10,20] - > Diff : 10]
*  Each candidate has to be sent to a city. If we make a mistake of sending 1st candidate to City[0](A)
*  We incur 350 more which is greater than 10 in other case. So ensure 1st is sent to City[1](B)
*  to minimize overall cost.
*  The difference in cost btw two cities will be our parameter for sorting.
*  The way we sort can lead to more concise code. Refer to two methods below : 
*
*  #2
*  [[10,20] -> Diff : 10, [30,200] -> Diff : 170, [400,50] -> Diff : 350, [30,20] -> Diff : 10]
*  Costs will be sorted in asc order of difference : 350, 170, 10, 10
*  Now we send candidates to cities by taking min(cost of two cities) until one city is full. 
*  Remaining will go to other city.
*
*  #1 (tricky and concise)
*  [[10,20] -> Diff : -10, [30,200] -> Diff : -170, [400,50] -> Diff : 350, [30,20] -> Diff : 10]
*  Costs will be sorted in asc order of difference : -170, -10, 10, 350
*  Since we've to send half candidates to each city, this ordering will result in all 
*  City[0](A) element first followed by City[1](B)
*
*  Time : O(nlogn)
*  Space : O(n) objects use merge sort(stable for duplicate keys);  
*               primitives use quick sort as relative order is not relevant for say two ints                                                                                      
*
*/
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));
        int n = costs.length / 2;
        int minCost = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println(Arrays.toString(cost));
            minCost += costs[i][0] + costs[i + n][1];
        }
        return minCost;
    }
    
    /* public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));
        int n = costs.length / 2;
        int minCost = 0;
        int cityA = n;
        int cityB = n;
        for (int[] cost : costs) {
            // System.out.println(Arrays.toString(cost));
            if (cityA > 0 && cityB > 0) {
                minCost += Math.min(cost[0], cost[1]);
                if (cost[0] < cost[1]) cityA--;
                else cityB--;
            }
            else if (cityA > 0) {
                minCost += cost[0];
                cityA--;
            }
            else {
                minCost += cost[1];
                cityB--;
            }
        }
        return minCost;
    } */
}
