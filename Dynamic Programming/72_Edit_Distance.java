class Solution {
    public int minDistance(String word1, String word2) {
        Map<String, Integer> memo = new HashMap<>();
        return calculateMinDistance(word1, word2, 0, 0, memo);
    }
    
    private int calculateMinDistance(String sourceWord, String targetWord, 
                                   int sourceIndex, int targetIndex, Map<String, Integer> memo) {
        if (sourceIndex == sourceWord.length()) {
            return targetWord.length() - targetIndex;
        }
        if (targetIndex == targetWord.length()) {
            return sourceWord.length() - sourceIndex;
        }
        
        String memoKey = sourceIndex + "," + targetIndex;
        
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }
        
        int result;
        
        if (sourceWord.charAt(sourceIndex) == targetWord.charAt(targetIndex)) {
            result = calculateMinDistance(sourceWord, targetWord, sourceIndex + 1, targetIndex + 1, memo);
        } else {
            int insertCost = calculateMinDistance(sourceWord, targetWord, sourceIndex, targetIndex + 1, memo);
            int deleteCost = calculateMinDistance(sourceWord, targetWord, sourceIndex + 1, targetIndex, memo);
            int replaceCost = calculateMinDistance(sourceWord, targetWord, sourceIndex + 1, targetIndex + 1, memo);
            
            result = 1 + Math.min(Math.min(insertCost, deleteCost), replaceCost);
        }
        
        memo.put(memoKey, result);
        return result;
    }
}
