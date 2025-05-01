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



    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        
        for (int i = 0; i <= s.length(); i++) {
            if (table[i]) {
                for (String word : wordDict) {
                    if (i + word.length() <= s.length() && 
                        s.substring(i, i + word.length()).equals(word)) {
                        table[i + word.length()] = true;
                    }
                }
            }
        }
        
        return table[s.length()];
    }
}