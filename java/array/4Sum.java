import java.util.Arrays;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            if(target < 0 && nums[i] > 0) break;
            for (int j = nums.length - 1; j > 2 && j > i; j--){
                if(target > 0 && nums[j] < 0) break;
                if((i > 0 && nums[i] == nums[i-1]) || (j < nums.length - 1 && nums[j] == nums[j+1])) continue;
                int right = j - 1;
                int left = i + 1;
                while (right > left){
                    if(left > i + 1 && nums[left] == nums[left-1]){
                        left++;
                        continue;
                    }
                    if(right < j - 1 && nums[right] == nums[right+1]){
                        right--;
                        continue;
                    }
                    if(nums[i] + nums[left] + nums[right] + nums[j] > target) right--;
                    else if(nums[i] + nums[left] + nums[right] + nums[j] < target) left++;
                    else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    temp.add(nums[j]);
                    ans.add(temp);
                    right--;
                    left++;
                    }
                }   
            }
        }
        return ans;
    }
}
//自己写的 虽不完善但也通过了那道题 （剪枝和去重）
//ai修正之后的
import java.util.Arrays;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            long min =(long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if(min > target) break;//当前i能组成的最小四数和已经超过target
            long max =(long) nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
            if(max < target) continue;//当前能组成最大的四数和都达不到target
            for (int j = nums.length - 1; j > 2 && j > i; j--){
                if(target > 0 && nums[j] < 0) break;
                if(j < nums.length - 1 && nums[j] == nums[j+1]) continue;
                int right = j - 1;
                int left = i + 1;
                while (right > left){
                    long sum = nums[i] + nums[left] + nums[right] + nums[j];
                    if(left > i + 1 && nums[left] == nums[left-1]){
                        left++;
                        continue;
                    }
                    if(right < j - 1 && nums[right] == nums[right+1]){
                        right--;
                        continue;
                    }
                    if(sum > target) right--;
                    else if(sum < target) left++;
                    else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    temp.add(nums[j]);
                    ans.add(temp);
                    right--;
                    left++;
                    }
                }   
            }
        }
        return ans;
    }
}
//题目链接：https://leetcode.cn/problems/4sum/
//这个题目的关键思路
//1. 先对数组进行排序。
//2. 使用两层循环固定四元组中的第一个数和第四个数。
//3. 在中间区间使用双指针寻找另外两个数。
//4. 找到满足条件的四元组后加入结果集。
//5. 对重复元素进行去重，避免出现重复答案。
//特别要说明的去重 这一题在排序和固定首位数的情况下 在中间区间寻找另外两个数 只要一个数与前数是重复的情况下 这种亲你你你你你你你你你你你你你你你你你你
