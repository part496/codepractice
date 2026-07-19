 class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int count = 0;
        for (int i = 0; i < weights.length; i++){
            count += weights[i];
        }
        int left = Arrays.stream(weights).max().getAsInt();
        int right = count;
        while (left < right){
            int mid = left + (right - left) / 2;
            int amount = 0;
            int day = 0;                                        //day = 1 因为不可能出现0天 直接从第一天开始判断 可以避免掉第二个elseif
            for (int i = 0; i < weights.length; i++){
                amount += weights[i];
                if(amount > mid){                               //这样写更简单 每一次加前先判断是否超过mid 如果没超就一直加weight 如果抄了那天数+1 并且当天的货物作为第二天的第一件货物                                                                                                           
                    i--;                                        //if(amount + weights[i] > mid){
                    day++;                                      //day++;
                    amount = 0;                                 //amount = weights[i];
                }else if(amount == mid){                        //}else amount += weights[i];
                    day++;
                    amount = 0;
                }else if(i == weights.length - 1) day++;
            }
            if(day > days) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
//题目链接：https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
//左边的代码是我第一次自己写的代码 右边的是ai进行改正的代码
