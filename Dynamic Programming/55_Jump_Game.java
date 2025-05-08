class Solution {
    public boolean canJump(int[] nums) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return canJumpMemo(nums, 0, memo);
    }

    private boolean canJumpMemo(int[] nums, int startIndex, HashMap<Integer, Boolean> memo) {
        if (startIndex == nums.length - 1) return true;
        if (startIndex >= nums.length) return false;
        if (memo.containsKey(startIndex)) {
            return memo.get(startIndex);
        }
        
        int maxJump = nums[startIndex];
        for (int jump = 1; jump <= maxJump; jump++) {
            if (canJumpMemo(nums, startIndex + jump, memo)) {
                memo.put(startIndex, true);
                return true;
            }
        }
        
        memo.put(startIndex, false);
        return false;
    }
}