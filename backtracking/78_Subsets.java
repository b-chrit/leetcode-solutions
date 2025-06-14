class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        generateSubsets(nums, allSubsets, new ArrayList<>(), 0);
        return allSubsets;
    }

    private void generateSubsets(int[] nums, List<List<Integer>> allSubsets, 
                                List<Integer> currentSubset, int startIndex) {
        allSubsets.add(new ArrayList<>(currentSubset));
        
        for (int i = startIndex; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            generateSubsets(nums, allSubsets, currentSubset, i + 1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
