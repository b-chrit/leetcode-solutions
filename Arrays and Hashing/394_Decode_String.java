class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                String substr = "";
                
                while (!stack.peek().equals("[")) {
                    substr = stack.pop() + substr;
                }
                stack.pop();
                
                String k = "";
                while (!stack.isEmpty() && stack.peek().matches("\\d")) {
                    k = stack.pop() + k;
                }
                
                stack.push(substr.repeat(Integer.parseInt(k)));
            }
        }
        
        return stack.peek();
    }
}
