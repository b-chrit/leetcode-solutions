import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list for the directed graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph (course -> prerequisites)
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(course).add(prereq);
        }
        
        // 0 = unvisited, 1 = visiting (in current DFS path), 2 = visited
        int[] visited = new int[numCourses];
        
        // Check each course
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(i, graph, visited)) {
                    return false; // Cycle detected, cannot finish
                }
            }
        }
        
        return true; // No cycle detected, can finish all courses
    }
    
    private boolean hasCycle(int course, List<List<Integer>> graph, int[] visited) {
        // If the course is being visited in current DFS path, we found a cycle
        if (visited[course] == 1) {
            return true;
        }
        
        // If the course has been fully processed, no need to check again
        if (visited[course] == 2) {
            return false;
        }
        
        // Mark as being visited in current path
        visited[course] = 1;
        
        // Check all prerequisites of this course
        for (int prereq : graph.get(course)) {
            if (hasCycle(prereq, graph, visited)) {
                return true;
            }
        }
        
        // Mark as fully processed
        visited[course] = 2;
        return false;
    }
}