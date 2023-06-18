package Bishi.duxiaoman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class duxiaoman01 {
    // 6 3 abaabc用例过不了
    // 求字符串的最大分数，分数的定义是子串中的最多字符出现次数-最少字符出现次数，求字符串中最大的分数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] res = new int[num];
        int count = 0;
        while (num > 0) {
            int length = sc.nextInt();
            int zilength = sc.nextInt();
            String s = sc.next();
            res[count++] = findMaxScore(s, length, zilength);
            num--;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int findMaxScore(String s, int length, int zilength) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
//        int[] map = new int[26];
        // 统计子串的最大分数和最小分数
        for (int i = 0; i < s.length() - zilength + 1; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < i + zilength; j++) {
                char c = s.charAt(j);
                int cnt = map.getOrDefault(c, 0) + 1;
                map.put(c, cnt);
            }
            int mapmax = Integer.MIN_VALUE;
            int mapmin = Integer.MAX_VALUE;
            // 一轮过后,遍历map,计算当前的分数
            for (Character k : map.keySet()) {
                // 求map中字符出现次数的最大值和最小值
                mapmax = Math.max(mapmax, map.get(k));
                mapmin = Math.min(mapmin, map.get(k));
            }
            // 会出现map中只有一个key的情况
            // 或者map中的每一个key都不同,这时候mapmin就不能置0了
            if (mapmax == mapmin && map.keySet().size() == 1) mapmin = 0;
            max = Math.max(mapmax - mapmin, max);
            min = Math.min(mapmax - mapmin, min);
        }
        if (max == min) return 0;
        return max;
    }
}
