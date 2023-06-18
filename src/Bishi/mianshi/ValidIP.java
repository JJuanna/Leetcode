package Bishi.mianshi;

import java.util.Scanner;

public class ValidIP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String address = in.next();
        System.out.println(isIPAddress(address));
    }

    public static String isIPAddress(String s) {
        String isIPv4 = "IPv4";
        String isIPv6 = "IPv6";
        String invalid = "Neither";
        // 先检查地址格式的合法性，统计分隔符的数量
        if (s.charAt(0) == ':' || s.charAt(s.length() - 1) == ':' || s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.')
            return invalid;
        // ipv4的地址，四部分，用.分隔，每一部分三个数字，范围在0-255之间，左右都是闭区间
        // ipv6地址，八部分，用:分隔，每一部分4个16进制数字，每一位的范围是0-F
        // 其他情况无效
        // 去除字符串中输入的引号
        String[] ipv4 = s.split("\\.");
        String[] ipv6 = s.split(":");
        boolean ipv4flag = false;
        boolean ipv6flag = false;
        if (ipv4.length == 4) {
            for (int i = 0; i < ipv4.length; i++) {
                // 检查每一部分的地址
                // 首位不能为0
                if (ipv4[i].length() > 1 && ipv4[i].charAt(0) == '0') return invalid;
                // 数字中不能有字母出现
                for (int j = 0; j < ipv4[i].length(); j++) {
                    if (ipv4[i].charAt(j) > 9) {
                        return invalid;
                    }
                }
                // 数字位在0-255之间
                int value = Integer.parseInt(ipv4[i]);
                if (!(value >= 0 && value <= 255)) {
                    return invalid;
                }
            }
            ipv4flag = true;
        }
        if (ipv6.length == 8) {
            for (int i = 0; i < ipv6.length; i++) {
                // 长度不能大于4
                if (ipv6[i].length() > 4 || ipv6[i].length() == 0) return invalid;
                // 判断每一位数字
                for (int j = 0; j < ipv6[i].length(); j++) {
                    char temp = ipv6[i].charAt(j);
                    temp = Character.toLowerCase(temp);
                    // 大小写转换
                    if (!(temp - '0' >= 0 && temp - '0' <= 9 || temp - 'a' >= 0 && temp - 'a' <= 5)) {
//                        ipv6flag = false;
                        return invalid;
                    }
                }
            }
            ipv6flag = true;
        }
        if (ipv4flag) return isIPv4;
        if (ipv6flag) return isIPv6;
        return invalid;
    }
}
