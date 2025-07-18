class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.min(minCostMemo(cost, 0, memo), minCostMemo(cost, 1, memo));
    }
    
    private int minCostMemo(int[] cost, int step, HashMap<Integer, Integer> memo) {
        if (step >= cost.length) {
            return 0;
        }
        
        if (memo.containsKey(step)) {
            return memo.get(step);
        }
        
        int result = cost[step] + Math.min(
            minCostMemo(cost, step + 1, memo),
            minCostMemo(cost, step + 2, memo)
        );
        
        memo.put(step, result);
        return result;
    }
}
