class Solution {
    public List<Integer>[] buildGraph(int[][] edges, int n) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = buildGraph(edges, n);
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
    
}

// Find shortest path distance in unweighted graph using BFS
// BFS guarantees shortest path since it explores nodes level by level
// Time: O(V + E), Space: O(V)
public class ShortestPathBFS {
    
    public static int shortestPath(List<List<Integer>> adjacencyList, int source, int destination) {
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<int[]> nodeQueue = new LinkedList<>();
        
        nodeQueue.offer(new int[]{source, 0});
        visitedNodes.add(source);
        
        while (!nodeQueue.isEmpty()) {
            int[] currentNodeData = nodeQueue.poll();
            int currentNode = currentNodeData[0];
            int currentDistance = currentNodeData[1];
            
            if (currentNode == destination) {
                return currentDistance;
            }
            
            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    nodeQueue.offer(new int[]{neighbor, currentDistance + 1});
                }
            }
        }
        
        return -1;
    }
}