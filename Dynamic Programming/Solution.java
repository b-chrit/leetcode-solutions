public class Solution {
    
    public int numDistinct(String s, String t) {
        Map<String, Integer> cache = new HashMap<>();
        return countSubsequences(s, t, 0, 0, cache);
    }
    
    private int countSubsequences(String source, String target, int sourceIndex, int targetIndex, Map<String, Integer> cache) {
        if (targetIndex == target.length()) return 1;
        if (sourceIndex == source.length()) return 0;
        
        String stateKey = sourceIndex + "," + targetIndex;
        if (cache.containsKey(stateKey)) return cache.get(stateKey);
        
        int subsequenceCount = countSubsequences(source, target, sourceIndex + 1, targetIndex, cache);
        
        if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
            subsequenceCount += countSubsequences(source, target, sourceIndex + 1, targetIndex + 1, cache);
        }
        
        cache.put(stateKey, subsequenceCount);
        return subsequenceCount;
    }
}