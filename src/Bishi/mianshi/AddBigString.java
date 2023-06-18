package Bishi.mianshi;

// 小米面试题
// 两个按钮，一个按钮将数字*2，一个按钮将数字-1，给定两个数，n和m，最少按几次能将n变成m
public class AddBigString {
    public static void main(String[] args) {
        String s1 = "9";
        String s2 = "99999999999999999999999999999999999999999999999999999999999994";
        System.out.println(add(s1, s2));
    }

    public static String add(String s1, String s2) {
        // 考虑特殊情况
        if(s1.equals("0")) return s2;
        if(s2.equals("0")) return s1;
        StringBuilder sb = new StringBuilder();
        // 思路，从低位相加，考虑进位，最后反转sb
        int carry = 0;
        int s1i = s1.length() - 1;
        int s2j = s2.length() - 1;
        while (s1i >= 0 && s2j >= 0) {
            int sum = Integer.parseInt(String.valueOf(s1.charAt(s1i))) + Integer.parseInt(String.valueOf(s2.charAt(s2j))) + carry;
            int add = sum % 10;
            carry = sum / 10;
            sb.append(add);
            s1i--;
            s2j--;
        }
        while (s1i >= 0) {
            int sum = Integer.parseInt(String.valueOf(s1.charAt(s1i))) + carry;
            int add = sum % 10;
            carry = sum / 10;
            sb.append(add);
            s1i--;
        }
        while (s2j >= 0) {
            int sum = Integer.parseInt(String.valueOf(s2.charAt(s2j))) + carry;
            int add = sum % 10;
            carry = sum / 10;
            sb.append(add);
            s2j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
