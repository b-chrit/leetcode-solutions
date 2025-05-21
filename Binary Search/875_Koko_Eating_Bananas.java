class Solution {
    public int minEatingSpeed(int[] piles, int maxHours) {
        int maxBananas = 0;
        for (int pile : piles) {
            maxBananas = Math.max(maxBananas, pile);
        }
        
        return findMinimumSpeed(piles, maxHours, 1, maxBananas);
    }
    
    private int findMinimumSpeed(int[] piles, int maxHours, int minSpeed, int maxSpeed) {
        if (minSpeed >= maxSpeed) {
            return minSpeed;
        }
        
        int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
        
        if (canEatAllBananas(piles, maxHours, midSpeed)) {
            return findMinimumSpeed(piles, maxHours, minSpeed, midSpeed);
        } else {
            return findMinimumSpeed(piles, maxHours, midSpeed + 1, maxSpeed);
        }
    }
    
    private boolean canEatAllBananas(int[] piles, int maxHours, int speed) {
        int hoursRequired = 0;
        
        for (int pile : piles) {
            hoursRequired += Math.ceil((double) pile / speed); // (pile + speed - 1) / speed
            
            if (hoursRequired > maxHours) {
                return false;
            }
        }
        
        return true;
    }
}