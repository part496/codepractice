class MinStack {

    int min = (int)Math.pow(2,31);
    int[] stack;
    int[] minStack;
    int top = 0;
    int top1 = 0;
    int maxSize;


    public MinStack() {
        maxSize = 3 * (int)Math.pow(10,4);
        stack = new int[maxSize];
        minStack = new int[maxSize];
    }
    
    public void push(int value) {
        stack[top++] = value;
        if(value <= min){
            minStack[top1++] = value;
            min = value;
        }
    }
    
    public void pop() {
        if(top1 > 1 && stack[top-1] == min) {
            min = minStack[top1-2];
            top1--;
        }else if(top1 == 1 && stack[top-1] == min) {
            min = (int)Math.pow(2,31);
            top1--;
        }
        top--;
        if(top == 0) min = (int)Math.pow(2,31);
    }
    
    public int top() {
        return stack[top-1];
    }
    
    public int getMin() {
        return minStack[top1-1];
    }
}
//题目链接：https://leetcode.cn/problems/min-stack/
//这个题主要用了双栈的方法 我头一次用所以记了
//因为这个题里面的所有方法运行时间只能是O(1) 所以得额外存一些数据避免重复扫描
//这里就用了minStack作为辅助栈 记录每次push进来后的最小值
