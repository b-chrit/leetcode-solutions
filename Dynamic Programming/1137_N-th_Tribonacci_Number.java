class Solution {
    public int tribonacci(int n) {
        return tribonacci(n, new HashMap<Integer, Integer>());
    }

    public int tribonacci(int n, HashMap<Integer, Integer> memo){
        if(n == 0) return 0;
        if(n <= 2) return 1;
        if(memo.containsKey(n)) return memo.get(n);

        int result = tribonacci(n-1, memo) + tribonacci(n-2, memo) + tribonacci(n-3, memo);
        memo.put(n, result);

        return result;
    }
}