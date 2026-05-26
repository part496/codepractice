int removeDuplicates(int* nums, int numsSize) {
    if (numsSize == 0) {
        return 0;
    }
    int fast = 1, slow = 1;
    while (fast < numsSize) {
        if (nums[fast] != nums[fast - 1]) {
            nums[slow] = nums[fast];
            ++slow;
        }
        ++fast;
    }
    return slow;
}
//题目链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solutions/728105/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
//思路：利用快指针和慢指针 快指针表示遍历数组到达的下标位置，慢指针表示下一个不同元素要填入的下标位置，当快指针发现前后数组值不同时就是，就将快指针所指赋给慢指针，从而达到保持原有相对顺序+去重的效果
//Easy
//时间复杂度o(n)
//空间复杂度O(1)
