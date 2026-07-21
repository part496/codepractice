1.普通二分

常见使用场景
1.数组整体有序
2.需要查找某个目标值是否存在 或找到目标值的位置
3.每次比较完nums[mid]和target后，可以排除一半的区间

编码思路
1. 定义 left 和 right 表示当前搜索区间。
2. 计算 mid = left + (right - left) / 2。
3. 比较 nums[mid] 和 target：
   - nums[mid] < target：搜索右半部分，left = mid + 1
   - nums[mid] > target：搜索左半部分，right = mid - 1
   - nums[mid] == target：找到答案

特别需要注意的一点 mid = left + (right - left) / 2是默认取左中位 当left = mid时会导致循环无法停止 这个时候需要写mid = left + (right - left + 1) / 2
   同理 right = mid时需要用mid = left + (right - left) / 2

class Solution {
    public int search(int[] nums, int target) {
       int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
//https://leetcode.cn/problems/binary-search/


2.特殊二分

常见使用场景
1.旋转排序数组。
2.查找左右边界。
3.查找峰值、最小值、分界点。
4.数组不是整体有序，但根据某些条件仍然可以判断答案一定在哪一边

核心仍然是找到一个判断条件 每次安全的派出一半搜索区间

编码思路
1. 确定当前搜索区间 left、right。
2. 计算 mid。
3. 分析题目的特殊性质，建立判断条件。
4. 根据判断结果确定答案一定在哪一侧。
5. 排除不可能存在答案的一半区间。
6. 不断缩小范围直到找到目标或边界。

这里需要注意的是 不要背left = mid + 1；或者right = mid - 1；亦或者 right = mid；
mid+1和mid-1都意味着在区间里面删除了mid 反之则是保留 这个时候我就需要判断 mid究竟有没有可能是答案 从而来判断代码如何书写

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[right] && nums[mid] == nums[left]){
                left++;
                right--;
            }else if(nums[mid] > nums[right]) {
                left = mid + 1;
            }else right = mid;
        }
        return nums[left];
    }
}
//https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
这个并非传统二分而是边搜索边判断 通过判断数据结构来判断target究竟在哪个区间


3.二分答案
顾名思义 就是对一个可能的答案区间进行二分

常见使用场景
最小速度
最小容量
最小除数
最大/最小某个数值

这种题目答案都是一个连续的空间通常见到
left 不满足 不满足 不满足  | 满足 满足 满足 right
                         ↑
                     找这个边界
   这种情况时由于边界右一直满足 所以通常right = mid 因为mid有可能是答案需要保留

或者
left 满足 满足 满足 | 不满足 不满足 不满足 right
                   ↑
               找这个边界
   这种情况时由于边界左一直满足 所以通常left = mid 因为mid有可能是答案需要保留
编码思路
1. 不对数组下标二分，而是确定“答案”的搜索范围 left ~ right。
2. 取一个候选答案 mid。
3. 写判断逻辑 check(mid)，判断 mid 是否满足题目要求。
4. 根据单调性缩小答案范围：
   - mid 不满足 → 答案需要更大，left = mid + 1
   - mid 满足 → mid 可能就是最小答案，right = mid
5. 当 left == right 时得到最终答案。


   
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int count = 0;
        for (int i = 0; i < weights.length; i++){
            count += weights[i];
        }
        int left = Arrays.stream(weights).max().getAsInt();
        int right = count;
        while (left < right){
            int mid = left + (right - left) / 2;
            int amount = 0;
            int day = 1;
            for (int i = 0; i < weights.length; i++){
                if(amount + weights[i] > mid){
                    day++;
                    amount = weights[i];
                }else amount += weights[i];
            }
            if(day > days) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
//https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
