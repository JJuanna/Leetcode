package num;

import java.util.Arrays;

public class no791 {
    // 双指针遍历(暴力查找)：时间复杂度O(n^2),空间复杂度O(n)
    public static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char p1 = order.charAt(i);
            for (int j = 0; j < sb.length(); j++) {
                if (p1 == sb.charAt(j)) {
                    // 可能有不止一个字符
                    res.append(p1);
                    sb1.deleteCharAt(sb1.indexOf(String.valueOf(p1)));
                }
            }
        }
        if (sb1.length() > 0) {
            res.append(sb1.toString());
        }
        return res.toString();
    }

    // 更好时间复杂度和空间复杂度的方法,排序法
    public static String customSortStringBetter(String order, String s) {
        // 先遍历order,按照次序给出现的字符赋权值
        int[] val = new int[26];
        for (int i = 0; i < order.length(); i++) {
            val[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        // 比较器返回正数，c0和c1交换，返回负数，则不交换
        Arrays.sort(arr, (c0, c1) -> val[c0 - 'a'] - val[c1 - 'a']);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String order = "kqep";
        String s = "pekeq";
        String res = customSortString(order, s);
        System.out.println(res);
    }
}
