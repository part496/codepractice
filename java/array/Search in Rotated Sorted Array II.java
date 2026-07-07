class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {//先判断mid是否是答案
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {//这种状况下无法判断 哪半边有序 所以只能两边一起缩小
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {//左半边有序
                if (nums[l] <= target && target < nums[mid]) {//target是否在这个半区
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {//右半边有序
                if (nums[mid] < target && target <= nums[n - 1]) {//target是否在这个半区
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
//链接：https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/description/
//核心思路在于每一轮二分都判断当前的left，right区间内哪一半有序 target是否落在这半边
//这个题与正常的旋转数组不同 因为存在相同的数字 当出现相同的数字无法判断该数组最小值在哪个半区 所以不能通过先找k的方式来做
//这道题是通过边搜索边判断的方式来做的
//我没做出来
