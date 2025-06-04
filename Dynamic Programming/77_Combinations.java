class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, result, new ArrayList<>(), 1);
        return result;
    }
    
    private void combine(int n, int k, List<List<Integer>> result, List<Integer> current, int start) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            current.add(i);
            combine(n, k, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}