双指针

常见使用场景

1.有序数组查找（左右夹逼）
2,数组元素删除、去重、移动
3.回文字符串判断

编码思路
1. 明确两个指针的含义和初始位置。
2. 根据题目条件判断移动左指针、右指针或同时移动。
3. 在移动过程中维护题目要求的条件。
4. 指针相遇或越界时结束循环，并处理边界情况。

例：
class Solution {
    public int maxArea(int[] height) {
        int max = height.length - 1;
        int min = 0;
        int num = (max - min) * Math.min(height[max],height[min]);
        while (max != min){
            int num1 = (max - min) * Math.min(height[max],height[min]);
            if(num1 > num) num = num1;
            if(height[max] > height[min]) min++;
            else max--;
        }
        return num;
    }
}
