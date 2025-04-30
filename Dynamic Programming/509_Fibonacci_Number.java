class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int fib(int n) {
        if(n < 2) return n;
        if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, fib(n - 1) + fib(n - 2));
        return memo.get(n);
    }


    public static int fib(int n) {
        if (n <= 1) return n;

        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }
}