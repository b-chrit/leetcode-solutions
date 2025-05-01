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


    // Map<Integer, Boolean> memo = new HashMap<>();
    // public static boolean canSum(int[] candidates, int target){
    //     if(memo.containsKey(target)) return memo.get(target);
    //     if(target == 0) return true;

    //     for(int candidate : candidates){
    //         int difference = target - candidate;
    //         if(canSum(candidates, difference) == true){
    //             memo.put(target, true);
    //             return memo.get(target);
    //         }
    //     }
    //     memo.put(target, false);
    //     return memo.get(target);
    // }

    public static boolean canSum(int[] candidates, int target) {
        boolean[] table = new boolean[target + 1];
        table[0] = true;

        for (int i = 0; i <= target; i++) {
            if (table[i]) {  
                for (int candidate : candidates) {
                    if (i + candidate <= target) { 
                        table[i + candidate] = true;
                    }
                }
            }
        }

        return table[target];
    }
}