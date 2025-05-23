class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();

        Map<Character, String> m = new HashMap<>();
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        
        List<String> res = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), res, m);
        return res;
    }
    
    private void dfs(String s, int i, StringBuilder sb, List<String> res, Map<Character, String> m) {
        if (i == s.length()) {
            res.add(sb.toString());
            return;
        }
        
        String letters = m.get(s.charAt(i));
        
        for (char c : letters.toCharArray()) {
            sb.append(c);
            dfs(s, i + 1, sb, res, m);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}