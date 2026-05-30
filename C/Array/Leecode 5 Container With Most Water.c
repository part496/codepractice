int maxArea(int* height, int heightSize) {
    int area = 0;
    int i = 0, j = heightSize - 1;
    while(i != j){
        int minheight;
        minheight = height[i] > height[j] ? height[j] : height[i];
        if(height[i] > height[j]){
           if(area < (j - i) * minheight) area = (j - i) * minheight;
           j--;
        }
        else{
            if(area < (j - i) * minheight) area = (j - i) * minheight;
            i++;
        }
        
    }
    return area;
}
//题目链接：https://leetcode.cn/problems/container-with-most-water/?envType=problem-list-v2&envId=array
//双指针：创造两个指针从两边向中间靠拢 直到指针相遇
//由于面积等于底乘相对矮的那个高 所以使相对矮的那个指针向中间移动 这样可以保证所有大的情况都被考虑到
//虽然底变短了 但高可能变大 面积可能变大
//反之如果移动那个相对高的那个指针 那么面积一定毕原来的面积小 因为实质上高没变 而底变短了
//medium
