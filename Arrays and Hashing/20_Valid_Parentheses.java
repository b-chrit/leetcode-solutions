class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        Map<Character, Character> myMap = new HashMap<>(){
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        for(char c: s.toCharArray()){
            if(myMap.containsKey(c) && !myStack.isEmpty()){
                if(myStack.peek() == myMap.get(c)){
                    myStack.pop();
                }else {return false;}
            }else{
                myStack.push(c);
            }
        }

        boolean answer = (myStack.isEmpty()) ? true : false;
        return answer;
    }
}