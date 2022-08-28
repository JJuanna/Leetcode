package num;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class no77 {
    // 求数字组合
    private static List<List<Integer>> res = new ArrayList<>();
    private static LinkedList<Integer> temp = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        // n>k的情况
        backtracing(1, n, k);
        return res;
    }

    public static void backtracing(int start, int end, int k) {
        if (k == temp.size()) {
            res.add(new ArrayList<>(temp));
            System.out.println("回退");
            return;
        }
        // 剪枝
        for (int i = start; i <= end - (k - temp.size()) + 1; i++) {
            System.out.println("回溯："+i);
            temp.add(i);
            backtracing(i + 1, end, k);
            // 撤销处理过的结点
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        res = new ArrayList<>();
        combine(4, 2);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
