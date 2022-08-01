package StackAndDeque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MonotonicStack {
    /*
    * 题目描述：给定一个连续时间段内的温度数组temperatures，输出一个同样长度的数组answer
    * answer[i]表示温度为temperatures[i]的那一天距离下一个比它温度高的那一天有几天
    * */
    public int[] dailyTemperatures(int[] temperatures) {
        // 解决方法：维护一个单调递减栈，单调栈中存储温度的下表，当当前温度大于栈顶存储的下标对应的温度的时候，
        // 这个下标对应的answer[i]就等于当前温度下标-栈顶下标i
        // 时间复杂度O(n),空间复杂度O(n)
        Deque<Integer> stack = new LinkedList<>();
        int[] answer = new int[temperatures.length];
        for(int i=0; i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                answer[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }
}
