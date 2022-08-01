package string;

import java.util.Deque;
import java.util.LinkedList;

public class DeleteAdjDuplicates {
    public String removeDuplicates(String s) {
        // 用栈实现
        // 类似括号匹配,O(n),O(n)
        Deque<Character> deque = new LinkedList<>();
        deque.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(!deque.isEmpty() && deque.peek()==s.charAt(i)) deque.pop();
            else{
                deque.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }
}
