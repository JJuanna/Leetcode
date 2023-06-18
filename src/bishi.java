import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bishi {
    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};
        List<List<Integer>> wall = new ArrayList<>();
        for (int i = 0; i < test.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < test[i].length; j++) {
                tmp.add(test[i][j]);
            }
            wall.add(tmp);
        }
        System.out.println(compute(wall));
    }

    public static int compute(List<List<Integer>> wall) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (List<Integer> width : wall) {
            int n = width.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += width.get(i);
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }
        return wall.size() - maxCount;
    }
}
