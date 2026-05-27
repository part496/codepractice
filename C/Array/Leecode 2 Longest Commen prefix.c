char* longestCommonPrefix(char** strs, int strsSize) {
    char *strs1 = *strs;
    int i;
    for (i = 0; strs1[i] != '\0'; i++)
    {
        for (int j = 1; j < strsSize; j++)
        {
            if (strs1[i] != strs[j][i] || strs[j][i] == '\0')
            {
                char *prefix = (char*)malloc((i+1)*sizeof(char));
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
//固定位置遍历字符串
