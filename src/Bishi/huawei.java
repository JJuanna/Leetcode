package Bishi;

import javafx.beans.binding.ObjectExpression;

import java.util.*;

public class huawei {
    public static void main(String[] args) {
//        int[] nums = {2,1,1,5,6,2,3};
//        System.out.println(jump(nums,3));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int in = N;
        ArrayList<String[]> al = new ArrayList<>();
        while (in-- > 0) {
            String[] s = new String[2];
            s[0] = sc.next();
            s[1] = sc.next();
            al.add(s);
        }
        System.out.println(divide(N, al));

    }

    // 带条件限制的跳台阶
    public static int jump(int[] nums, int k) {
        int res = 0, prior = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(cur, nums[i] + i);
            if (cur >= nums.length) {
                return ++res;
            }
            if (i == prior) {
                prior = cur;
                ++res;
                if (res >= k) {
                    return -1;
                }
            }
        }
        return res;
    }

    // 给小朋友分组
    public static int divide(int N, ArrayList<String[]> al) {
        Map<String, Integer> map = new HashMap<>();
        int mark = 1;
        int res = 1;
        if (N > 0) {
            map.put(al.get(0)[0], mark);
            map.put(al.get(0)[1], mark);
        }
        for (int i = 1; i < N; i++) {
            String key1 = al.get(i)[0];
            String key2 = al.get(i)[1];
            // 可能得到空值
            Object value1 = map.get(key1);
            Object value2 = map.get(key2);
//            System.out.println(value1);
//            System.out.println(value2);
            // 如果出现两个key得到的value不同，需要将两个key的value改为较小的value,以及和两个key相关联的key的value也需要修改
            if (value1!=null && value2!=null && value1!=value2) {
                // 遍历map,如果有这两个key对应的相同value，都修改
                int minValue = map.get(key1) < map.get(key2) ? map.get(key1) : map.get(key2);
                int maxValue = map.get(key1) > map.get(key2) ? map.get(key1) : map.get(key2);
                map.put(key1, minValue);
                map.put(key2, minValue);
                for(String key: map.keySet()){
                    if(map.get(key)==maxValue){
                        map.put(key, minValue);
                    }
                }
                res--;
            } else {
                if (map.containsKey(key1)) {
                    map.put(key2, map.get(key1));
                } else if (map.containsKey(key2)) {
                    map.put(key1, map.get(key2));
                } else {
                    // 如果都没有，就重新建立一个分组
                    mark++;
                    res++;
                    map.put(key1, mark);
                    map.put(key2, mark);
                }
            }
        }
//        Set<Integer> hs = new HashSet<>(map.values());
        return res;
    }
}

//6
//        Jack Tom
//        Alice John
//        Jessica Leonie
//        Tom Alice
//        John Jack
//        Leonie Jessica