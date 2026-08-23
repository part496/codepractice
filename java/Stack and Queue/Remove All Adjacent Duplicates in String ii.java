class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] str = new char[s.length()];
        int[] count = new int[s.length()];//这个数组的作用是记录str顶栈的重复次数
        int top = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(top > 0 && str[top-1] != ch){
                count[top] = 1;
                str[top++] = ch;
                continue;
            }else if(top > 0 && str[top-1] == ch && k-1 == count[top-1]){
                top -= (k-1);
                continue;
            }
            if(top == 0 || str[top-1] == ch){
                if(top != 0) count[top] = count[top-1] + 1;
                else count[top] = 1;
                str[top++] = ch;
            }
        }
        for (int i = 0; i < top; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
//题目链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string-ii/description/
//这个题有个十分特殊的点是count和str共用同一个top
//由于count这个数组作用是记录str顶栈的重复次数 所以可以共用同一个top 相当于是给这个str这个栈增加了一个特性
//这个题遍历s之后会遇到三种情况 一是ch与顶栈相同 二是ch与顶栈不同 第三种情况则是栈为空
//而第一种情况 又可以分为 重复次数达到k-1 和重复次数没到的
//由于这道题的count的特殊作用 所以当ch与顶栈相同时 count[top]要等于顶栈加1
//当要出栈的时候 直接top减少 因为str出栈了重复的字符 count自然也把重复的字符所记录的所有count出栈了
