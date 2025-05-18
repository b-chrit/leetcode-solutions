class Solution {
    HashMap<Integer, Integer> myMap = new HashMap<>();
    
    public int climbStairs(int n) {
        if(myMap.containsKey(n)) return myMap.get(n);
        if(n == 0) return 1;
        if(n < 0 ) return 0;

        int result = climbStairs(n-1) + climbStairs(n-2);
        myMap.put(n, result);
        return result;
    }
}