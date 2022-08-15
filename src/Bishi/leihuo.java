package Bishi;

public class leihuo {
    public static void main(String[] args) {
        System.out.println(solution(1000, 25));
    }

    public static int solution(int n, int x) {
        int result = 0;

        //转换为目标字符串
        String goal = String.valueOf(x);
        //得到其数字的长度
        int len = goal.length();
        //遍历x到n的所有数字
        for (int i = x; i <= n; i++) {
            String num = String.valueOf(i);
            //循环分割字符串
            for (int j = 0; j <= num.length() - len; j++) {
                //得到连续的定长字符串
                String sub = num.substring(j, j + len);
                //与目标字符串比较
                if (goal.equals(sub)) result++;
            }
        }
        return result;
    }
}
