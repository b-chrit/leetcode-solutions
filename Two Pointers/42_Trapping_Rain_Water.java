class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        int total = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                total += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                total += maxRight - height[right];
                right--;
            }
        }

        return total;
    }
}

class SolutionSuboptimal {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }
        
        maxRight[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }
        
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        
        return total;
    }
}
