class MyQueue {
    
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;

    
    public MyQueue() {
        stackIn = new ArrayDeque<>();
        stackOut = new ArrayDeque<>();
    }

    public void push(int x) {

        stackIn.push(x);
    }

    // 删除并返回队首元素
    public int pop() {

        // 如果输出栈为空，说明当前没有可以直接出队的元素
        if (stackOut.isEmpty()) {

            // 把输入栈中的所有元素倒入输出栈
            while (!stackIn.isEmpty()) {

                // stackIn 的栈顶元素弹出，
                // 再压入 stackOut
                stackOut.push(stackIn.pop());
            }
        }

        // 两次反转以后，最早进入队列的元素就在 stackOut 栈顶
        // 直接弹出即可模拟队列的出队
        return stackOut.pop();
    }

   
    public int peek() {

        // 如果输出栈为空，同样需要先进行一次倒栈
        if (stackOut.isEmpty()) {

            // 将输入栈中的元素全部倒入输出栈
            while (!stackIn.isEmpty()) {

                stackOut.push(stackIn.pop());
            }
        }

        // stackOut 栈顶就是当前队首
        return stackOut.peek();
    }

    public boolean empty() {

        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}

题目链接

https://leetcode.cn/problems/implement-queue-using-stacks/