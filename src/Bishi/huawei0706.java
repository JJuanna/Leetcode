package Bishi;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class huawei0706 {


// 匹配文本中的域名
    public static ArrayList<String> res = new ArrayList();
    public static String getDomainString(String str) {
//        String reg = "^(?=^.{3,255}$)(http(s)?:\\/\\/?)(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}\\.com+";
        // 这个可以识别前面和后面有字符的网址
        String reg = "(http(s)?://)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.com)+";

        // 下面这个不能识别前面有字符的网址
//        String reg = "^(?=^.{3,255}$)(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*([\\?&]\\w+=\\w*)*$";

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group().replace("http://","").replace("https://","");
        }
        return "none";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        for (int i = 0; i < line+1; i++) {
            String s = scanner.nextLine();
            System.out.println(s);
            if (!getDomainString(s).equals("none")) {
                if(!res.contains(getDomainString(s))) {
                    res.add(getDomainString(s).toLowerCase());
                }
            }
        }
        if (res.isEmpty()) {
            System.out.println("none");
        }else{
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

// http://www.book-org.com
//    https://www.abc.com:9000


}
