void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int* num = (int*)malloc((nums1Size)*sizeof(int));
    for (int i = 0; i < m; i++){
        num[i] = nums1[i];
    }
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m && j < n){//当num与nums2都没有达到边界时 将num与nums2的值 比较填入
        if(num[i] <= nums2[j]) nums1[k++] = num[i++];
        else nums1[k++] = nums2[j++];
    }
    while (i < m){//如果是nums2达到边界 将num的值复制进nums1
        nums1[k++] = num[i++];
    }
    while (j < n){//同上
        nums1[k++] = nums2[j++];
    }
    free(num);
}
//题目链接:https://leetcode.cn/problems/merge-sorted-array/?envType=problem-list-v2&envId=array
//easy
