public class test {
    public static void main (String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
      //从左向右遍历数组，记录柱子+雨水面积总和
      //定义数组记录从左向右看的数据（想象右边有一个墙壁）
        int[] leftMax = new int[arr.length];
        int temp = leftMax[0];
        for (int i = 0; i < arr.length; i++) {
            if(temp > arr[i]){
                leftMax[i] = temp;
            }else{
                temp = arr[i];
                leftMax[i] = temp;
            }
        }
      //从右向左遍历数组，记录柱子+雨水面积总和
      //定义数组记录从右向左看的数据（想象左边有一个墙壁）
        int[] rightMax = new int[arr.length];
        temp = rightMax[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if(temp > arr[i]){
                rightMax[i] = temp;
            }else{
                temp = arr[i];
                rightMax[i] = temp;
            }
        }
      //取交集
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(leftMax[i] < rightMax[i]){
                result[i] = leftMax[i];
            }else{
                result[i] = rightMax[i];
            }
        }
      //求和所有result中的数据
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += result[i];
        }
      //去掉柱子
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        }
        System.out.println(sum);
    }
}
//代码的目的是将数组大小想象成对应长短的墙壁 最后算这些墙壁所围部分体积
//动态规划思想 整体的思路 再从右到左算出每个位置右侧的最高柱子 先从左到右算出每个位置左侧的最高柱子 
//取两者中的较小值减去当前位置的柱子高度 就是该位置的蓄水量 最后累加即得答案
