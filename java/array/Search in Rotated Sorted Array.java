class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){//这里不能写成left <= right 因为当left == right时 会一直进入else 不退出循环 虽然我自己想出来了 但是我还是想强调一下
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) left = mid + 1;//此处已经证明mid及其左侧不可能是旋转处 所以可以+1排除掉mid
            else right = mid;//不能写成right = mid + 1 因为这个地方只能判断mid右侧不是旋转处 不能判断mid自身是否是旋转处 所以不能+1
        }//旋转处的mid要求左侧大于mid右侧也大于mid     这个题实际上是从左右两边不断逼近旋转处的过程
        int k = left;
        if(nums[0] > target || k == 0){
        left = k;
        right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
            else return mid;
            }
        }else{
            left = 0;
            right = k - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] > target) right = mid - 1;
                else if(nums[mid] < target) left = mid + 1;
                else return mid;
            }
        }
        return -1;
    }
}
//题目链接：https://leetcode.cn/problems/search-in-rotated-sorted-array/
//思路为先找k所在地 后从0至k-1找target或者k至最后找target（我写这道题思路是对的 主要是边界问题 可以看我代码旁边的注释）
