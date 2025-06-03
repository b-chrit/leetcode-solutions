class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        boolean[] used = new boolean[nums.length];
        permute(nums, result, new ArrayList<>(), used);
        
        return result;
    }
}