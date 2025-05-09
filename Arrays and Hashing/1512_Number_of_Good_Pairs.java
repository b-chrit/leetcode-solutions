class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int goodPairs = 0;
    
        for (int num : nums) {
            int previousCount = count.getOrDefault(num, 0);
            goodPairs += previousCount;
            count.put(num, previousCount + 1);
        }
        
        return goodPairs;
    }
}