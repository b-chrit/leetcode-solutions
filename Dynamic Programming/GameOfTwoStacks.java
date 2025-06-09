/*
 *  Problem: Find the maximum number of elements you can remove from two stacks such that their sum doesn't exceed a given maximum.
    (https://www.hackerrank.com/challenges/game-of-two-stacks/problem)
    Approach: Recursive solution with memoization that explores taking elements from either stack at each step.

    Time Complexity: O(n × m × maxSum)
    Space Complexity: O(n × m × maxSum)
 */
public class GameOfTwoStacks {
    
    public static int maxElementsFromTwoStacks(int maxSum, int[] stackA, int[] stackB) {
        Map<String, Integer> cache = new HashMap<>();
        return findMaxElements(stackA, stackB, 0, 0, maxSum, cache);
    }
    
    private static int findMaxElements(int[] stackA, int[] stackB, int indexA, int indexB, 
                                     int remainingSum, Map<String, Integer> cache) {
        if (indexA >= stackA.length && indexB >= stackB.length) {
            return 0;
        }
        
        String currentState = indexA + "," + indexB + "," + remainingSum;
        if (cache.containsKey(currentState)) {
            return cache.get(currentState);
        }
        
        int maxElementsCount = 0;
        
        if (indexA < stackA.length && stackA[indexA] <= remainingSum) {
            maxElementsCount = Math.max(maxElementsCount, 
                1 + findMaxElements(stackA, stackB, indexA + 1, indexB, 
                                  remainingSum - stackA[indexA], cache));
        }
        
        if (indexB < stackB.length && stackB[indexB] <= remainingSum) {
            maxElementsCount = Math.max(maxElementsCount, 
                1 + findMaxElements(stackA, stackB, indexA, indexB + 1, 
                                  remainingSum - stackB[indexB], cache));
        }
        
        cache.put(currentState, maxElementsCount);
        return maxElementsCount;
    }
}