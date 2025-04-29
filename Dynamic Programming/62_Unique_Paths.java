class Solution {
    HashMap<String, Integer> myMap = new HashMap<>();
    public int uniquePaths(int m, int n) {
        String key = m + "," + n;
        if(myMap.containsKey(key)) return myMap.get(key);
        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return 1;

        myMap.put(key, uniquePaths(m - 1, n) + uniquePaths(m, n - 1));

        return myMap.get(key);
    }
}