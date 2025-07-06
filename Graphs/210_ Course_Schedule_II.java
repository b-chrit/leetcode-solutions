class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
        }
        
        int[] state = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(graph, i, state, result)) {
                    return new int[0];
                }
            }
        }
        
        Collections.reverse(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int course, int[] state, List<Integer> result) {
        if (state[course] == 1) {
            return true;
        }
        if (state[course] == 2) {
            return false;
        }
        
        state[course] = 1;
        
        for (int neighbor : graph.get(course)) {
            if (hasCycle(graph, neighbor, state, result)) {
                return true;
            }
        }
        
        state[course] = 2;
        result.add(course);
        
        return false;
    }
}
