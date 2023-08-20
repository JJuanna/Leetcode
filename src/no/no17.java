package no;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class no17 {
    private static Map<Character, String> map;
    private static List<String> res = new ArrayList<>();
    private static StringBuilder temp = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        map = new HashMap<>();
        // 向map中填数据
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxxy");
        backtracking(0, digits);
        return res;
    }

    public static void backtracking(int index, String digits) {
        // 终止条件
//        if (index == digits.length()) {
//            return;
//        }
        if (temp.length() == digits.length()) {
            res.add(temp.toString());
            return;
        }
        // 获取当前层的字母
        String chars = map.get(digits.charAt(index));
        // 单层搜索
        for (int i = 0; i < chars.length(); i++) {
            temp.append(chars.charAt(i));
            backtracking(index + 1, digits);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {

        res = letterCombinations("");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
