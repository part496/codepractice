class RecentCounter {

    int[] time;
    int rear;
    int front;

    public RecentCounter() {
        time = new int[10000];
        rear = 0;
        front = 0;
    }

    public int ping(int t) {
        while (front < rear && time[front] < (t-3000)) front++;
        time[rear++] = t;
        return rear - front;
    }
}
//题目链接：https://leetcode.cn/problems/number-of-recent-calls/
