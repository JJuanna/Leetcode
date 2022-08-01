package num;

import java.util.LinkedList;
import java.util.Scanner;

public class no42 {
    public static boolean strStrKMP(String haystack, String needle) {
        // KMP算法的思想:在模式串和主串匹配的过程中，当遇到坏字符后，对于已经对比好的前缀，如何找到一种规律，将模式串一次滑动多位
        // 时间复杂度O(m+n),空间复杂度O(m)(m表示needle的长度, n表示haystack的长度)
        int[] next = getNext(needle, needle.length());
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 和pattern比对
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                // 滑动位置
                j = next[j - 1] + 1;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++j;
            }
            if (j == needle.length()) {
                return true;
            }
        }
        return false;
    }

    private static int[] getNext(String needle, int m) {
        int[] next = new int[m];
        next[0] = -1;
        // k指向前缀末尾位置
        int k = -1;
        // i指向后缀末尾位置
        for (int i = 1; i < m; i++) {
            while (k != -1 && needle.charAt(k + 1) != needle.charAt(i)) {
                // 回退k
                k = next[k];
            }
            if (needle.charAt(k + 1) == needle.charAt(i)) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        int m,n;
        String[] pattern;
        String[] jiyin;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        pattern = new String[n+1];
        for (int i = 0; i <= n; i++) {
            pattern[i] = sc.nextLine();
        }
        m = sc.nextInt();
        jiyin = new String[m+1];
        for (int i = 0; i <= m; i++) {
            jiyin[i] = sc.nextLine();
        }
        for (int i = 1; i <= m; i++) {
            boolean hero = false;
            for(int j=1; j<=n; j++){
                if(no42.strStrKMP(jiyin[i],pattern[j])){
                    hero = true;
                    break;
                }
            }
            if(hero){
                System.out.println("A new hero discovered");
            }else{
                System.out.println("Just an ordinary person");
            }
        }
    }

}
