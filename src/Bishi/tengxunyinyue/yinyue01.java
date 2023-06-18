package Bishi.tengxunyinyue;

public class yinyue01 {
    public static int minOperations(String str) {
        // 统计字符串中0和1的个数
        int one = 0;
        int zero = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') zero++;
            else one++;
        }
        int count = 0;
        if (one > zero) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    count++;
                    // 不管后面是不是0,i都需要后移一位
                    i++;
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    count++;
                    i++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "000000000";
        System.out.println(minOperations(s));
    }
}
