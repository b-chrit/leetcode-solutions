class Solution {
    Map<String, List<String>> memo = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> results = new ArrayList<>();

        if (s.length() == 0) {
            results.add("");
            return results;
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subResults = wordBreak(s.substring(word.length()), wordDict);
                
                for (String subResult : subResults) {
                    if (subResult.isEmpty()) {
                        results.add(word);
                    } else {
                        results.add(word + " " + subResult);
                    }
                }
            }
        }
        
        memo.put(s, results);
        return results;
    }
}