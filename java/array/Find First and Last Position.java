class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else{
                right = mid - 1;
                res[0] = mid;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else{
                left = mid + 1;
                res[1] = mid;
            }
        }
        return res;
    }
}
//题目链接；https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
//这道题思路是分别两个while 寻找左边界和有边界 时间复杂度O(logn)
//注意： 当 nums[mid] == target 时，不能立即结束循环，因为无法确定当前 mid 是否为目标值的左边界（或右边界）。
//因此需要先记录当前下标，然后继续向左（或向右）进行二分查找。如果搜索过程中再次遇到 target，就继续更新答案。直到 left > right，最后一次记录的下标就是目标值的左边界（或右边界）。
