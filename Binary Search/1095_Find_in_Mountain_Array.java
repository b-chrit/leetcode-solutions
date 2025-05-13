/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        
        int peakIndex = findPeakIndex(mountainArr, 0, length - 1);
        
        int result = binarySearch(mountainArr, 0, peakIndex, target, true);
        
        if (result != -1) {
            return result;
        }
        
        return binarySearch(mountainArr, peakIndex + 1, length - 1, target, false);
    }
    
    private int findPeakIndex(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int binarySearch(MountainArray mountainArr, int left, int right, int target, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if ((isAscending && midVal < target) || (!isAscending && midVal > target)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}