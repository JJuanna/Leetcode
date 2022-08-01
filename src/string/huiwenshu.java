package string;

public class huiwenshu {
    /**
     * 判断回文数
     * 输入：int型数字
     * 输出：boolean型 输入的数字是否为回文数
     * */
    // 方法一：将
    public boolean isPalindrome1(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        // 用两个指针实现,起始时分别指向头和尾
        // 将整数转化为String
        String s = String.valueOf(x);
        int len = s.length();
        int left=0, right=len-1;
        while(left<=right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }

    // 方法二


    public static void main(String[] args) {
        huiwenshu m = new huiwenshu();
        System.out.println(m.isPalindrome1(121));
    }

    // 二进制回文数
    // 思路：
}
