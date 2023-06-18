package num;

import java.util.Stack;

public class no1003 {
    public static boolean isValid(String s) {
        // s只由a、b、c三个字母组成，s满足对于s中的任意一个原子字符串t来说 t==t_left + t_right
        // 将字母逐个入栈，如果入栈的字母数大于等于三，且栈顶三个字母包含abc三个字母，那么将这三个字母出栈并且记录出栈的顺序
        Stack<Character> deque = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            deque.push(s.charAt(i));
            if (deque.size() >= 3) {
                // 出栈栈顶的三个字符
                for (int j = 0; j < 3; j++) {
                    sb.append(deque.pop());
                }
                System.out.println(sb);
                // 判断
                if (!(sb.toString().equals("cba"))) {
                    // 重新入栈
                    for (int k = 2; k >= 0; k--) {
                        deque.push(sb.charAt(k));
                    }
                }
                // 初始化sb
                sb = new StringBuilder();
                // 入栈当前新的字母
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "aabcbc";
        System.out.println(isValid(s));
    }
}
