class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int fib(int n) {
        if(n < 2) return n;
        if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, fib(n - 1) + fib(n - 2));
        return memo.get(n);
    }
}