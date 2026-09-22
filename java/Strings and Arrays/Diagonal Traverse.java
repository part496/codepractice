//方法1：
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] nums = new int[mat.length*mat[0].length];
        int i = 0;
        int j = 0;
        boolean up = true;
        for (int k = 1; k < mat.length*mat[0].length; k++){
            nums[k-1] = mat[i][j];
            if(up){//对角线向右上遍历
                if(i == 0 && j != mat[0].length-1){//需要变换遍历方向的第一种情况 就是正常遍历到右上的顶点了 然后换对角线遍历
                    j++;
                    up = false;
                }else if(j == mat[0].length-1){//需要变换遍历方向的第二种情况 就是右上顶点到二维数组的右边界了 然后换对角线遍历
                    i++;
                    up = false;
                }else{
                    j++;
                    i--;
                }
            }else{
                if(j == 0 && i != mat.length-1){//需要变换遍历方向的第一种情况 就是正常遍历到左下的顶点了 然后换对角线遍历
                    i++;
                    up = true;
                }else if(i == mat.length-1){//需要变换遍历方向的第二种情况 就是左下顶点到二维数组的下边界了 然后换对角线遍历
                    j++;
                    up = true;
                }else{
                    j--;
                    i++;
                }
            }
        }
        nums[mat.length*mat[0].length-1] = mat[i][j];
        return nums;
    }
}
//说实话这个做法就是把所有情况都列举出来 但是时间复杂度小



//方法2：
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] nums = new int[mat.length*mat[0].length];
        int count = 0;
        for (int sum = 0; sum <= mat.length+mat[0].length-2; sum++){
            if(sum % 2 == 0){
                for (int i = mat.length-1; i >= 0; i--){
                int j = sum - i;
                if(j < 0 || j >= mat[0].length) continue;
                nums[count] = mat[i][j];
                count++;
                }
            }else{
                for (int i = 0; i < mat.length; i++){
                int j = sum - i;
                if(j < 0 || j >= mat[0].length) continue;
                nums[count] = mat[i][j];
                count++;
                }
            }
        }
        return nums;
    }
}
//https://leetcode.cn/problems/diagonal-traverse/description/
//由于从右上至左下这个对角线上的点的共同特点是行和列坐标相加相同
//这类对角线从左向右相加所得的值逐渐加1
//所以for一个sum出来遍历一个二维数组中所有的对角线
//内层的for负责遍历当前对角线中所有的点
//因为这些点行列坐标相加相同 所以只用遍历行或者列就可以得到这个点的具体坐标
//最后因为这题第偶数条对角线和第奇数条对角线遍历方向不同所以 区分出来以后更改遍历行的初始值就行
