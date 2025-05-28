class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return duplicates;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = Math.abs(nums[i]);
            int targetIndex = currentNumber - 1;
            
            if (nums[targetIndex] < 0) {
                duplicates.add(currentNumber);
            } else {
                nums[targetIndex] = -nums[targetIndex];
            }
        }
        
        return duplicates;
    }
}