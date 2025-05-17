class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return memoizedCount(nums, target, 0, 0, memo);
    }
    
    private int memoizedCount(int[] nums, int target, int index, int currentSum, Map<String, Integer> memo) {
        if (index == nums.length) {
            return (currentSum == target) ? 1 : 0;
        }
        
        String key = index + "_" + currentSum;
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int addWays = memoizedCount(nums, target, index + 1, currentSum + nums[index], memo);
        int subtractWays = memoizedCount(nums, target, index + 1, currentSum - nums[index], memo);
        
        int totalWays = addWays + subtractWays;
        
        memo.put(key, totalWays);
        
        return totalWays;
    }
    
}