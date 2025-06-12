public class Solution {
    private int rows;
    private int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        Set<String> pac = new HashSet<>();
        Set<String> atl = new HashSet<>();

        // Start DFS for Pacific Ocean
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pac, heights, Integer.MIN_VALUE);
            dfs(rows - 1, c, atl, heights, Integer.MIN_VALUE);
        }

        // Start DFS for Atlantic Ocean
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pac, heights, Integer.MIN_VALUE);
            dfs(r, cols - 1, atl, heights, Integer.MIN_VALUE);
        }

        // Prepare the result
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String key = r + "," + c;
                if (pac.contains(key) && atl.contains(key)) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    res.add(cell);
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, Set<String> visit, int[][] heights, int prevHeight) {
        String key = r + "," + c;

        if (visit.contains(key) || r < 0 || c < 0 || r >= rows || c >= cols || heights[r][c] < prevHeight) {
            return;
        }

        visit.add(key);
        dfs(r + 1, c, visit, heights, heights[r][c]);
        dfs(r - 1, c, visit, heights, heights[r][c]);
        dfs(r, c + 1, visit, heights, heights[r][c]);
        dfs(r, c - 1, visit, heights, heights[r][c]);
    }
}
