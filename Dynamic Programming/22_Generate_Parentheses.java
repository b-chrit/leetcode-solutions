public class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> validCombinations = new ArrayList<>();
        buildValidParentheses(validCombinations, "", 0, 0, n);
        return validCombinations;
    }
    
    private void buildValidParentheses(List<String> validCombinations, String currentString, 
                                     int openCount, int closeCount, int totalPairs) {
        if (currentString.length() == totalPairs * 2) {
            validCombinations.add(currentString);
            return;
        }
        
        if (openCount < totalPairs) {
            buildValidParentheses(validCombinations, currentString + "(", 
                                openCount + 1, closeCount, totalPairs);
        }
        
        if (closeCount < openCount) {
            buildValidParentheses(validCombinations, currentString + ")", 
                                openCount, closeCount + 1, totalPairs);
        }
    }
}