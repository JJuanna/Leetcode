package string;

import java.util.Arrays;

/**
 * 给定一个字符串，找这个字符串的重复子串，如果这个字符串的长度不能整除重复子串，
 * 主串中剩余的部分必须和子字符串中从左开始的等长部分相同
 */
public class findPatternClass {
    // 方法一：暴力匹配算法，时间复杂度是O(n),n为字符串的长度
    // 具体方法：使用三个指针i,j,end，分别标识主串的字符下标和模式串的字符下标，以及再有一个指针end标识模式串的下一个字符作为结尾
    // 步骤一：先在主串中找到模式串：从主串的下标0开始，向后遍历，直到找到和主串下标0字符相同的字符为止，
    // 此时可能会是一个模式串的结尾，也可能不是，但是先标记end，从当前位置开始，i和j都同时向后移动，进行比较匹配，
    // 如果i走到end的位置，说明end标记的位置是循环串的结尾，如果不是，i从i=0开始，j从上一个end后面开始，重复之前的动作开始匹配
    public String findPattern1(String str) {
        if (str.length() > 1) {
            int i = 0;
            int j = 1;
            int end = 0;

            while (j < str.length()) {
                while (j < str.length() && str.charAt(j) != str.charAt(i)) {
                    j++;
                }
                end = j;
                while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                    i++;
                    j++;
                    if (i == end) {
                        i = 0;
                    }
                }
                if (j != str.length()) {
                    i = 0;
                    j = end + 1;
                }
            }
            if (end >= str.length()) {
                return "no pattern";
            }
            return str.substring(0, end);
        }
        return "no pattern";
    }


    // KMP思想，求next数组
    // 时间复杂度和空间复杂度都是O(n)
    public String findPattern2(String str) {
        int len = str.length();
        String res = "no pattern";
        int[] next = new int[len + 1];
        // 初始化next数组
        Arrays.fill(next, -1);
        if (len == 1) return res;
        for (int i = 2, cn = 0; i <= len; i++) {
            if (str.charAt(i - 1) == str.charAt(cn)) {
                next[i] = ++cn;
            } else if (cn == 0) {
                next[i] = 0;
            } else {
                cn = next[cn];
            }
        }
        int cyclelen = len - next[len];
        if (cyclelen >= len) {
            return res;
        } else {
            return str.substring(0, cyclelen);
        }
    }

    public static void main(String[] args) {
        findPatternClass method = new findPatternClass();
        String s = method.findPattern2("123121");
        System.out.println(s);
    }
}
