package Bishi.gongshanghang;

// 字符串压缩
public class StringYaSuo {
    public static void main(String[] args) {
        System.out.println(
                compress("ccddf")
        );
    }

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                sb.append(str.charAt(i));
                if (count > 1) {
                    sb.append(count);
                    count = 1;
                }
            }

        }
        // 处理最后一个字母，不管前面的字母是否相同，都没有append上
        sb.append(str.charAt(str.length() - 1));
        if (count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }
}
