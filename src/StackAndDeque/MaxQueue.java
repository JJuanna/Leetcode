package StackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxQueue {
    private Deque<Integer> queue;
    // 存储最大值，保持队列单调递减（和59-I思路相同）
    private Deque<Integer> help;
    public MaxQueue() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        if(queue.isEmpty()) return -1;
        int max = help.peekFirst();
        return max;
    }

    public void push_back(int value) {
        // 尾部入队列
        // 保持辅助队列单调递减
        while(!help.isEmpty() && value > help.peekLast()) help.removeLast();
        help.addLast(value);
        queue.addLast(value);
    }

    public int pop_front() {
        // 头部出队列
        if(queue.isEmpty()) return -1;
        int front = queue.peekFirst();
        if(front == help.peekFirst()){
            help.removeFirst();
        }
        queue.removeFirst();
        return front;
    }
}