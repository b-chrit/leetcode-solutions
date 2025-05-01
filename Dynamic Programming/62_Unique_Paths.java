class Solution {
    // HashMap<String, Integer> myMap = new HashMap<>();
    // public int uniquePaths(int m, int n) {
    //     String key = m + "," + n;
    //     if(myMap.containsKey(key)) return myMap.get(key);
    //     if(m == 0 || n == 0) return 0;
    //     if(m == 1 && n == 1) return 1;

    //     myMap.put(key, uniquePaths(m - 1, n) + uniquePaths(m, n - 1));

    //     return myMap.get(key);
    // }


     public int uniquePaths(int m, int n) {
        int[][] table = new int[m+1][n+1];
        table[1][1] = 1;

        for(int i = 0; i <= m ; i++){
            for(int j = 0; j <= n ; j++){
                int current = table[i][j];
                if(j + 1 <= n) table[i][j + 1] += current;
                if(i + 1 <= m) table[i + 1][j] += current; 
            }
        }

        return table[m][n];
     }
}