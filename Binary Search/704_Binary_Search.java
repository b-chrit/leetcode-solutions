class Solution {

    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while(left <= right){
        int middleIndex = left + (right - left) / 2;
        if(nums[middleIndex] == target) return middleIndex;
        if(target < nums[middleIndex]){
            right = middleIndex - 1;
        }else{
            left = middleIndex + 1;
        }
      }
      return -1;
    }

    public int search(int[] nums, int target) {
    if(nums == null || nums.length == 0) return -1;
    return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right){
        if(left > right) return -1;

        int middleIndex = left + (right - left) / 2;
        if(nums[middleIndex] == target) return middleIndex;
        if(target < nums[middleIndex]){
           return search(nums, target, left, middleIndex - 1);
        }else{
           return search(nums, target, middleIndex + 1, right);
        }
    }





     /**
     * Performs binary search on a sorted array (either ascending or descending)
     * @param arr The sorted array to search in
     * @param target The element to search for
     * @return The index of the target element if found, otherwise -1
     */
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = arr.length - 1;
        
        boolean isAscending = arr[start] < arr[end];
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }
}