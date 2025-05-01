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

    Map<Integer, int[]> memo = new HashMap<>();

    public int[] howSum(int[] candidates, int target) {
    if (memo.containsKey(target)) return memo.get(target);
    if (target == 0) return new int[0];
    if (target < 0) return null;

    for (int candidate : candidates) {
        int remainder = target - candidate;
        int[] remainderResult = howSum(candidates, remainder);
        
        if (remainderResult != null) {
            int[] result = new int[remainderResult.length + 1];
            System.arraycopy(remainderResult, 0, result, 0, remainderResult.length);
            result[remainderResult.length] = candidate;
            memo.put(target, result);
            return result;
        }
    }

    memo.put(target, null);
    return null;
    }

    Map<Integer, int[]> memo = new HashMap<>();
    public static int[] bestSum(int[] candidates, int target) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new int[0];
        if (target < 0) return null;

        int[] shortestCombination = null;

        for (int candidate : candidates) {
            int remainder = target - candidate;
            int[] remainderResult = bestSum(candidates, remainder);

            if (remainderResult != null) {
                int[] combination = new int[remainderResult.length + 1];
                System.arraycopy(remainderResult, 0, combination, 0, remainderResult.length);
                combination[remainderResult.length] = candidate;
                
                if (shortestCombination == null || combination.length < shortestCombination.length) {
                    shortestCombination = combination;
                }
            }
        }

        memo.put(target, shortestCombination);
        return shortestCombination;
    }
}