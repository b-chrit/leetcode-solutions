class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        cost = java.util.Arrays.copyOf(cost, n + 1);
        cost[n] = 0;
        
        for (int i = n - 2; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        
        return Math.min(cost[0], cost[1]);
    }
}