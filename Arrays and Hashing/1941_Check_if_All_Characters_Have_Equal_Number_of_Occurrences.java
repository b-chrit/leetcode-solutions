class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        
        for(char c : s.toCharArray()){
            charToCount.put(c, charToCount.getOrDefault(c, 0 ) + 1);
        }

        int count = -1;
        
        for(char c : s.toCharArray()){
            if(count == -1){
                count = charToCount.get(c);
                continue;
            }

            if(count != charToCount.get(c)) return false;
        }

        return true; // we can also just do return new HashSet<>(count.values()).size() == 1; instead of the 2nd loop :)
    }
}
