import java.util.ArrayList;
import java.util.List;

public class bishi2 {

    static ArrayList[] cache = new ArrayList[11];

    public static void main(String[] args) {
        int n = 10;
        List<String> res = kuohao(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<String> kuohao(int n) {
        List<String> res = new ArrayList<String>();
        if (cache[n] != null) {
            return cache[n];
        }
        if (n == 0) {
            res.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : kuohao(i)) {
                    for (String right : kuohao(n - 1 - i)) {
                        res.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = (ArrayList) res;
        return res;
    }
}

//    public static void backtracking(List<String> res, StringBuilder current, int open, int close, int max) {
//        if (current.length() == max * 2) {
//            res.add(current.toString());
//            return;
//        }
//        if (open < max) {
//            current.append('(');
//            backtracking(res, current, open + 1, close, max);
//            current.deleteCharAt(current.length() - 1);
//        }
//        if (close < open) {
//            current.append(')');
//            backtracking(res, current, open, close + 1, max);
//            current.deleteCharAt(current.length() - 1);
//        }
//    }
//}
