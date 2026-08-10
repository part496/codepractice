class Solution {
    public boolean backspaceCompare(String s, String t) {
        int tops = s.length() - 1;
        int topt = t.length() - 1;
        int counts = 0;
        int countt = 0;
        while (tops >= 0 ||topt >= 0){
            while (tops >= 0){
                if(s.charAt(tops) == '#') {
                    counts++;
                    tops--;
                }
                else if(counts > 0) {
                    counts--;
                    tops--;
                }else break;
            }
            while (topt >= 0){
                if(t.charAt(topt) == '#'){
                    countt++;
                    topt--;
                }
                else if(countt > 0) {
                    countt--;
                    topt--;
                }else break;
            }
            if (tops < 0 && topt < 0) return true;
            if (tops < 0 || topt < 0) return false;
            if (s.charAt(tops) != t.charAt(topt)) return false;
            tops--;
            topt--;
        }
        return true;
    }
}
//题目链接：https://leetcode.cn/problems/backspace-string-compare/description/
//这个题的这个方法没用到栈或者队列 用到栈的那个方法我做出来了 但是用的时间较长 这个方法不需要用stringbuilder模拟栈我没有完全独立做出了
//当时我做的时候大体思路其实我也想到了 一些细枝末节的东西没处理好
//最开始是用了count的 但是后面以为没用就删除了 并且当时没想到三个while叠加 我当时是写在一个while里面的 我知道有问题 但是不知道怎么改 我当时以为三个while时间会很长
//这个题的思路就是 外面那个大while判断两个字符是否全部都遍历完了 里面的两个while就是判断是否是有效字符（不被退格的字符）
//是有效字符先判断一下两个字符走完没 没走完就判断一下是不是相等的
