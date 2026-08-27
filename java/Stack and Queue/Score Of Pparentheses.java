class Solution {
    public int scoreOfParentheses(String s) {
        int[] stack = new int[s.length() + 1];
        int top = 1; // stack[0] 作为最外层总分

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);//每一个()称为一层

            if (ch == '(') {
                stack[top] = 0;
                top++;//ch为( 视为新开一层 分数初始化为0
            } else {
                top--;//ch为) 分数记在上一层(这样做的原因是可以通过上一层的分数判断究竟是+1还是*2)

                int cur = stack[top];//取出当前层的分数

                if (cur == 0) {//说明这一层是() 应该+1
                    cur = 1;
                } else {
                    cur *= 2;//说明这一层是(A) 应该*2
                }

                stack[top - 1] += cur;//将当前层的所有分数汇总到上一层
            }
        }

        return stack[0];//最后所有栈都会全部出栈 只剩下标为0的栈所以返回这个
    }
}
//题目链接：https://leetcode.cn/problems/score-of-parentheses/description/
//这道题比较新颖啊 别的题目主栈都是保存题目的主体 这个栈保存的是当前层累计的分数
//这个题就是在括号不断进入的情况下 不断将分数汇总到最外层的括号
