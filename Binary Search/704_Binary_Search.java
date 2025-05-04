class Solution {
    public int search(int[] nums, int target) {
    //   int left = 0;
    //   int right = nums.length - 1;

    //   while(left <= right){
    //     int middleIndex = left + (right - left) / 2;
    //     if(nums[middleIndex] == target) return middleIndex;
    //     if(target < nums[middleIndex]){
    //         right = middleIndex - 1;
    //     }else{
    //         left = middleIndex + 1;
    //     }
    //   }
    //   return -1;
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
}