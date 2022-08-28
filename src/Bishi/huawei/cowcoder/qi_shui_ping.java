package Bishi.huawei.cowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class qi_shui_ping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str);
        while (num != 0) {
            int ret = change(num);
            System.out.println(ret);
            num = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static int change(int num) {
        int ret = 0;
        // 换瓶子的规则：三个空汽水瓶换一瓶汽水
        int count_null = num;
        while (count_null > 1) {
            // 当前能换到的最多瓶子
            int temp = count_null / 3;
            // 汽水数量记录
            ret += count_null / 3;
            // 更新空瓶数量
            count_null -= 2 * temp;
            // 判断是否需要和可以借瓶子
            // 只有只剩两个瓶的情况，才可以借一个瓶子
            if (count_null == 2) {
                ret += 1;
                break;
            }
        }
        return ret;
    }
}
