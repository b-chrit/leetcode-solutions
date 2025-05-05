class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        int completeCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                // BFS to find all nodes in the component
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    component.add(curr);
                    
                    for (int neighbor : graph[curr]) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
                
                // Check if this component is complete
                if (isCompleteComponent(component, graph)) {
                    completeCount++;
                }
            }
        }
        
        return completeCount;
    }
    
    private boolean isCompleteComponent(List<Integer> component, List<Integer>[] graph) {
        int size = component.size();
        // Each vertex in a complete component should have (size-1) edges
        for (int node : component) {
            if (graph[node].size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}