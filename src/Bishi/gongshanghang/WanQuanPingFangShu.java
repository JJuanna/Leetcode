package Bishi.gongshanghang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 完全平方数
// 给定一个n,找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
// 其中每个平方数不能重复，且要求输出的结果从小到大；若不存在这样的平方数，则输出NULL。
// 方法二：贪心
// 力扣279改
public class WanQuanPingFangShu {
    public static void main(String[] args) {
        int n = 12;
        List<Integer> lst = greedy(n);
        if (lst.size() == 0) {
            System.out.println("NULL");
        } else {
            for (Integer e : lst) {
                if (e == lst.get(lst.size() - 1)) {
                    System.out.println(e);
                } else {
                    System.out.print(e + " ");
                }
            }
        }
    }

    public static List<Integer> greedy(int n) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stc = new Stack<>();
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            n -= i * i;
            if (n >= 0) {
                stc.push(i * i);
            }
            if (n < 0) {
                // 恢复
                n += i * i;
            }
            if (n == 0) {
                while (!stc.isEmpty()) {
                    res.add(stc.pop());
                }
            }
        }
        return res;
    }
}
