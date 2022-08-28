package num;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class no216 {
    private static List<List<Integer>> res;
    private static LinkedList<Integer> temp;
    private static int N;

    public static List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        N = n;
        backtracing(1, 9, k);
        return res;
    }

    public static void backtracing(int start, int end, int k) {
        if (k == temp.size()) {
            if (add(temp) == N) {
                res.add(new ArrayList<>(temp));
            }

            return;
        }
        // 剪枝
        for (int i = start; i <= end - (k - temp.size()) + 1; i++) {
            temp.add(i);
            backtracing(i + 1, end, k);
            // 撤销处理过的结点
            temp.removeLast();
        }
    }

    private static int add(LinkedList<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
//        res = combinationSum3(3, 7);
        res = combinationSum3(3, 9);
//        res = combinationSum3(3, 6);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
