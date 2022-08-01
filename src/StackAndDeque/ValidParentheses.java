package StackAndDeque;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    /*
     * 给定一组括号，判断这组括号是否能完全配对
     * 使用栈实现
     * 时间复杂度O(n),空间复杂度O(n)
     * */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // 先入栈字符串第一个元素
        stack.push(s.charAt(0));
        // 括号匹配，用哈希表匹配
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && map.getOrDefault(stack.peek(), ' ') == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
