package Bishi.nohang;

import java.util.*;

public class poker {
    // 扑克牌顺序
    // 首先按照大小鬼、黑桃、红桃、梅花、方块进行花色排序
    // 同一花色内部从小到大排序
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pokers = sc.nextLine().split(" ");

        // 用map存储花色的顺序
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'k');
        map.put(2, 's');
        map.put(3, 'h');
        map.put(4, 'p');
        map.put(5, 'q');

        Map<Character, List<String>> pokerMap = new HashMap<>();
        // 1.按照不同类型分别存储
        // 2.内部排序
        for (int i = 0; i < pokers.length; i++) {
            char huase = pokers[i].charAt(0);
            List<String> temp = new ArrayList<>();
            if (pokerMap.containsKey(huase)) {
                temp = pokerMap.get(huase);
            }
            temp.add(pokers[i]);
            pokerMap.put(huase, temp);
        }
        // 花色内部排序，交换排序
        for (Character huase : pokerMap.keySet()) {
            List<String> temp = pokerMap.get(huase);
            // 选择排序
            for (int i = 0; i < temp.size(); i++) {
                int min = i;
                // 找最小的元素下标
                for (int j = i + 1; j < temp.size(); j++) {
                    if (temp.get(j).charAt(1) < temp.get(min).charAt(1)) {
                        min = j;
                    }
                }
                // 交换最小元素和i位置所在的值交换
                if (i != min) {
                    String str = temp.get(i);
                    temp.set(i, temp.get(min));
                    temp.set(min, str);
                }
            }
        }
        // 排序之后将结果，按照花色排序
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            if (pokerMap.containsKey(map.get(i))) {
                List<String> temp = pokerMap.get(map.get(i));
                for (String s : temp) {
                    sb.append(s + ",");
                }
            }
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }

}
