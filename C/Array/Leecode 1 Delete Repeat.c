int removeDuplicates(int* nums, int numsSize) {
    int fast = 1;
    int slow = 0;
    int count = 1;//count用来记录一共有几个元素 第一个元素一定存在 不会被删除 所以count = 1
    while (fast < numsSize){
        if(nums[fast] != nums[slow]){
            nums[++slow] = nums[fast];
        }
        fast++;
    }
    return count;
}
//题目链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solutions/728105/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
//思路：利用快指针和慢指针 快指针表示遍历数组到达的下标位置，慢指针表示下一个不同元素要填入的下标位置
//当快指针发现与慢指针数组值不同时，慢指针先++，到下一位置后，就将快指针所指赋给慢指针，从而达到保持原有相对顺序+去重的效果
//Easy
//时间复杂度o(n)
//空间复杂度O(1)
