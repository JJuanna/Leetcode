package no;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class no554 {


    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> w : wall) {
            int n = w.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return wall.size()-max;
    }
}
