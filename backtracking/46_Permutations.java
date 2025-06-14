class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        boolean[] used = new boolean[nums.length];
        permute(nums, result, new ArrayList<>(), used);
        
        return result;
    }
    
    private void permute(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                
                permute(nums, result, current, used);
                
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}