char* longestCommonPrefix(char** strs, int strsSize) {
    char *strs1 = *strs;
    int i;
    for (i = 0; strs1[i] != '\0'; i++)//固定位置
    {
        for (int j = 1; j < strsSize; j++)//遍历字符串
        {
            if (strs1[i] != strs[j][i] || strs[j][i] == '\0')//发现公共前缀到i-1位截止
            {
                //创造一个新数组存放公共前缀
                char *prefix = (char*)malloc((i+1)*sizeof(char));//0至i-1共i个字符 加上\0所以创造一个大小为i+1的内存
                for (int k = 0; k < i; k++)
                {
                    prefix[k] = strs1[k];
                }
                prefix[i] = '\0';
                return prefix;
            }
        }
    }
    return strs1;
}
//题目链接；https://leetcode.cn/problems/longest-common-prefix/?envType=problem-list-v2&envId=array
//思路；固定位置遍历字符串
//注意：最内层for循环
//easy
