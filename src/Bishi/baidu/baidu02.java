package Bishi.baidu;
import java.util.Scanner;
public class baidu02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if(temp>0) m[i] = 1;
            else m[i] = -1;
        }
        int[] res = compute(m);
        System.out.print(res[0]);
        System.out.print(" ");
        System.out.println(res[1]);
    }

    public static int[] compute(int[] m) {
        int[] res = new int[2];
        // 0表示黑魔法，乘积为正数，1表示白魔法，乘积为负数, 先输出黑魔法数，载输出白魔法数
        // 暴力法时间复杂度为
        int windowlength = 1;
        while (windowlength <= m.length) {
            for (int i = 0; i <= m.length - windowlength; i++) {
                int mutil = 1;
                for (int j = i; j < i + windowlength; j++) {
                    mutil *= m[j];
                }
                if (mutil > 0) {
                    res[1]++;
                } else {
                    res[0]++;
                }
            }
            windowlength++;
        }
        return res;
    }
}
