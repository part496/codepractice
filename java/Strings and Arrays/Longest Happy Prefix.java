class Solution {
    public String longestPrefix(String s) {
        if(s.length() == 1) return "";
        int[] next = new int[s.length()+1];
        StringBuilder sb = new StringBuilder();
        next[0] = -1;
        int i = 0;//理解成被验证的已经验证的字符串长度
        int j = -1;
        while (i < s.length()){
            if(j == -1 || s.charAt(i) == s.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
        for (int p = 0; p < j; p++){
            sb.append(s.charAt(p));
        }
        return sb.toString();
    }
}
//题目链接 ：https://leetcode.cn/problems/longest-happy-prefix/
/*
 * 这道题和普通 KMP 求 next 的区别：
 * 普通 KMP：
 * next[j] 是给“模式串下标 j 的字符匹配失败”时使用的
 * 所以只需要求到 next[n - 1]。
 * 当最后一个字符也匹配成功后，模式串已经全部匹配完成，
 * 不需要再计算 next[n]。
 *
 * 本题：
 * 要求的是“整个字符串”的最长相等真前后缀。
 * 因此需要知道整个长度为 n 的字符串对应的前后缀长度，
 * 也就是还要比普通 KMP 多计算一步，得到 next[n]。
 *
 * 所以：
 * 普通 KMP：next 数组长度 n，循环到 i < n - 1
 * 本题：     next 数组长度 n + 1，循环到 i < n
 *
 * 最终 j 表示最长相等真前后缀的长度，不是下标。
 */
/*
 * 注意：
 * 字符串下标只有 0 ~ n-1，不存在 s[n]。
 *
 * 这里 next[i] 的 i 不是字符下标，而是“前缀长度”。
 * next[i] 表示长度为 i 的前缀的最长相等真前后缀长度。
 *
 * 普通 KMP 匹配时只需要 next[0] ~ next[n-1]，
 * 因为它们用于模式串各字符失配后的回退。
 *
 * 本题要知道整个长度为 n 的字符串的最长相等真前后缀，
 * 所以需要额外求 next[n]。
 */
