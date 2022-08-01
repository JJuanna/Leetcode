package StackAndDeque;

import java.util.Stack;

/*
* 用栈实现队列
* 栈的特性是先入后出，队列的特性是先入先出
* */
public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public MyQueue() {
        // 用栈初始化队列
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    /*
    * x入队
    * */
    public void push(int x) {
        stackIn.push(x);
    }
    /*
    * 出队队首元素
    * */
    public int pop() {
        // 先判空
        if(stackOut.isEmpty()){
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }
    /*
    * 返回队首元素
    * */
    public int peek() {
        if(stackOut.isEmpty()){
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
    /*
    * 队列判空
    * */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
