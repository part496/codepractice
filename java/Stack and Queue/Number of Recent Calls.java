class RecentCounter {

    int[] time;
    int rear;
    int front;

    public RecentCounter() {//构造方法
        time = new int[10000];
        rear = 0;
        front = 0;
    }

    public int ping(int t) {
        while (front < rear && time[front] < (t-3000)) front++;//之前的代码写的是front到rear全遍历 但是实际上只用遍历到满足要求即可
        time[rear++] = t;                                      // 因为只存在 [不满足 不满足 不满足 不满足 满足 满足 满足]
        return rear - front;
    }
}
//题目链接：https://leetcode.cn/problems/number-of-recent-calls/
//这个题我独立做出来了 但是不是这份代码我那份代码时间要的久一点 但是思路是正确的
//我记录这个的原因是 主要告诉自己变量是可以根据题目要求写在方法外的 另外这种题型比较新所以我就记下来了
