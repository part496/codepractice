void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int* num = (int*)malloc((nums1Size)*sizeof(int));
    for (int i = 0; i < m; i++){
        num[i] = nums1[i];
    }
    int i = 0;//相较下面的错误答案 这里通过ijk来分别管理num nums1 nums2 这样就不会越位了
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
//原代码
//错误主要原因 p1和p2指针越位导致的代码出错
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int* num = (int*)malloc((nums1Size)*sizeof(int));
    memset(num,100,sizeof(int)*(nums1Size));//不需要用memset
    for (int i = 0; i < m; i++){
        num[i] = nums1[i];
    }
    int* p1 = num;
    int* p2 = nums2;
    if (n != 0 && m != 0){
        for (int i = 0; i < nums1Size; i++){
            if(*p1 <= *p2) nums1[i] = *p1++;//没有控制p1和p2 假设p1走到了num的最后一位 p1还是会++ 这个时候就会超出已经定义的范围就会出现垃圾值
            else nums1[i] = *p2++;//没有控制p2
        }
    }else if (n != 0 && m == 0){
        for (int i = 0; i < nums2Size; i++){
            nums1[i] = nums2[i];
        }
    }
    free(num);
}
