class Solution {
    HashMap<Integer, List<List<Integer>>> myMap = new HashMap<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (myMap.containsKey(target)) {
            return myMap.get(target);
        }
        if (target == 0) {
            List<List<Integer>> baseResult = new ArrayList<>();
            baseResult.add(new ArrayList<>());
            return baseResult;
        }
        if (target < 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int candidate : candidates) {
            int difference = target - candidate;
            List<List<Integer>> subResult = combinationSum(candidates, difference);

            if (subResult != null) {
                for (List<Integer> combination : subResult) {
                    if (combination.isEmpty() || candidate >= combination.get(combination.size() - 1)) {
                        List<Integer> newCombination = new ArrayList<>(combination);
                        newCombination.add(candidate);
                        result.add(newCombination);
                    }
                }
            }
        }

        myMap.put(target, result);
        return result;
    }
}