class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(memo.containsKey(s)) return memo.get(s);
        if(s.length() == 0) return true;

        for(String word : wordDict){
            if(s.startsWith(word)){
                if(wordBreak(s.substring(word.length()), wordDict) == true){
                    memo.put(s, true);
                    return memo.get(s);
                } 
            }
        }
        memo.put(s, false);
        return memo.get(s);
    }
}