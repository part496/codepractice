class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxLeft = values[0];
        int max = 0;
        for (int j = 1; j < values.length; j++){
            max = Math.max(max,maxLeft + values[j] - j);
            maxLeft = Math.max(maxLeft,values[j] + j); 
        }
        return max;
    }
}
//题目链接：https://leetcode.cn/problems/best-sightseeing-pair/
//这个题 主要是把values[i] + values[j] + i - j 整理成(values[i] + i) + (values[j] - j)
//这样左边就可以统一用maxLeft来表示 就是正常遍历j遇到比maxLeft大的(values[j] + j) 然后maxLeft就进行更新
//由于i < j 所以maxleft必须在j的左边 所以就得先更新最大得分 再更新maxLeft 反之先更新maxLeft 就会可能出现values[j] + j + values[j] - j的情况
