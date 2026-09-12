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
 *
 * 1. next[i] 的含义在两者中完全一样。
 *    这里的 i 不是字符串字符下标，而是“前缀长度”。
 *    next[i] 表示：长度为 i 的前缀，它的最长相等真前后缀长度。
 *
 *    例如 s = "abab"：
 *    next[1] 描述 "a"
 *    next[2] 描述 "ab"
 *    next[3] 描述 "aba"
 *    next[4] 描述 "abab"
 *
 *    字符串本身的下标仍然只有 0 ~ n-1，不存在 s[n]。
 *    next[n] 中的 n 表示“整个长度为 n 的前缀”，不是字符下标 n。
 *
 * 2. 为什么普通 KMP 只求到 next[n-1]？
 *    普通 KMP 的 next 数组是给“某个模式串字符匹配失败后怎么回退”使用的。
 *    模式串最后一个字符的下标是 n-1，因此最多只会用到 next[n-1]。
 *
 *    求 next[n-1] 时，研究的是前面长度为 n-1 的前缀，
 *    所以在求 next 的预处理阶段，不需要再把最后一个字符 s[n-1] 算进去。
 *
 * 3. 普通 KMP 其实也会比较模式串最后一个字符。
 *    但这个比较发生在“正式匹配阶段”：
 *    模式串最后一个字符 s[n-1] 会和主串当前位置的字符比较，
 *    目的是判断整个模式串是否已经匹配成功。
 *
 *    如果最后一个字符也匹配成功，模式串已经完整匹配，任务结束，
 *    不需要再问“整个模式串自身还有多长的公共前后缀”，所以不需要 next[n]。
 *
 * 4. 本题 1392 不一样。
 *    本题没有主串和模式串，它要求的就是“整个字符串自身”的最长相等真前后缀。
 *    因此必须让最后一个字符也参与字符串内部的前后缀比较，
 *    再多推进一步，得到 next[n]。
 *
 *    也就是说，两者虽然都会“比较最后一个字符”，但目的不同：
 *    普通 KMP：最后一个字符是在正式匹配阶段，与主串字符比较，判断是否匹配完成。
 *    1392：最后一个字符是在字符串内部自比较，用来判断整个字符串的公共前后缀还能否延长。
 *
 * 5. 所以代码边界不同：
 *    普通 KMP 求 next：next 数组长度 n，循环到 i < n - 1，只需求到 next[n-1]。
 *    本题 1392：      next 数组长度 n + 1，循环到 i < n，需要求到 next[n]。
 *
 * 6. 最终 j 表示最长相等真前后缀的“长度”，不是最后一个字符的下标。
 *    所以答案应取 s 的前 j 个字符，即下标 0 ~ j-1。
 */
