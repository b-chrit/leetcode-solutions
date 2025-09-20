/*
Logic:
- Use DFS to try coloring the graph with 2 colors (1 and -1).
- Each node's neighbors must have the opposite color.
- If a conflict occurs (neighbor already has same color), return false.
- If no conflicts, the graph is bipartite.
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!dfs(graph, colors, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (!dfs(graph, colors, neighbor, -color)) {
                return false;
            }
        }
        return true;
    }
}
