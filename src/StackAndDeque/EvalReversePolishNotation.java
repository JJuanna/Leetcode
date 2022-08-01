package StackAndDeque;

import java.util.*;

public class EvalReversePolishNotation {
    // + - * / 不会入栈
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < tokens.length; ++i) {
            if ("+".equals(tokens[i])) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(tokens[i])) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(tokens[i])) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
