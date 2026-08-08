class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] nums = new int[deck.length];
        int rear = 0;
        for (int i = deck.length - 1; i >= 0; i--){
            if(rear >0) {
                int last = nums[rear-1];
                for (int j = rear; j > 1; j--){
                    nums[j] = nums[j-2];
                }
                nums[1] = last;
            }
            nums[0] = deck[i];
            rear++;
        }
        return nums;
    }
}
//https://leetcode.cn/problems/reveal-cards-in-increasing-order/
//这个题题型很新啊 当时做的时候一点思路也没有 这个题是知道答案进行反推
//整体思路 由于要从大到小的输出 所以最开始对数组排序 后面新创一个数组来输出结果
//最后将原数组从大到小放入新数组中 可以根据题目例子的解释反过来看 最终确认数字的位置变化规律
//每次将新数放在最开始处（因为输出的是最前面的数字） 最后一位的数字向前移动到第二位 所以中间的所有数依次向后移动两格 来腾出空间
//在中间数组的移动过程中 要从右向左移动这样才不会导致移动数字覆盖之后的数字
