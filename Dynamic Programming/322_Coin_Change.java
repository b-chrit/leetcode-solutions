class Solution {
    HashMap<Integer, Integer> myMap = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (myMap.containsKey(amount)) return myMap.get(amount);

        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int minimumNumberOfSteps = Integer.MAX_VALUE;
        for (int coin : coins) {
            int difference = amount - coin;
            int result = coinChange(coins, difference);
            if (result >= 0) { 
                minimumNumberOfSteps = Math.min(minimumNumberOfSteps, result + 1);
            }
        }

        // Store the result in the map
        int finalResult = (minimumNumberOfSteps == Integer.MAX_VALUE) ? -1 : minimumNumberOfSteps;
        myMap.put(amount, finalResult);

        return finalResult;
    }
}
