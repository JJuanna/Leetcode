package Bishi.Keep;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class getSleepTime {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] query = new int[]{6,5,4,3,2};
        int[] res = count(nums, query);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] count(int[] nums, int[] query) {
        int[] res = new int[query.length];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < query.length; j++) {
                if(!map.containsKey(query[j])){
                    map.put(query[j], 0);
                }
                if (nums[i] >= query[j]) {
                    map.put(query[j], map.getOrDefault(query[j], 0) + 1);
                }
            }
        }
        int i = 0;
        for (Integer key : map.keySet()) {
            res[i++] = map.get(key);
        }
        return res;
    }
}
