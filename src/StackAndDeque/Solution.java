package StackAndDeque;

import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    /**
     * 有效括号序列
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        // write code here
        HashMap<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        if (s.isEmpty()) return true;
        Stack<Character> deque = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty()) {
                deque.push(s.charAt(i));
                continue;
            }
            Character tmp = deque.peek();
            if (map.get(tmp) == s.charAt(i)) {
                deque.pop();
            }else deque.push(s.charAt(i));
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
