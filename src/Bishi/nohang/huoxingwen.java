package Bishi.nohang;

import java.util.HashMap;
import java.util.Map;

public class huoxingwen {

    // 将十进制转三进制,除k取余法,用火星文表示
    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, '@');
        map.put(1, '$');
        map.put(2, '&');
        String res = TenConvertToThree(map, 456);
        System.out.println(res);
    }

    public static String TenConvertToThree(Map<Integer, Character> map, int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int temp = num % 3;
            sb.append(map.get(temp));
            num /= 3;
        }
        sb.reverse();
        return sb.toString();
    }

}
