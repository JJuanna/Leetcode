package string;

import java.util.HashMap;
import java.util.Map;

public class strMatch {
    /*
     * 字符串匹配
     * KMP算法
     * */
    public int strStrBF(String haystack, String needle) {
        // BF算法
        // 思想：每发现一个不匹配的字符，主串匹配起点后移一位
        // 时间复杂度O((n-m+1)*m),n为主串的长度，m为模式串的长度
        if (needle.length() == 0) return 0;
        int p1 = 0, p2 = 0;
        // 表示起点
        int flag = 0;
        while (p1 < haystack.length()) {
            if (haystack.charAt(p1) == needle.charAt(p2)) {
                p1++;
                p2++;
            } else {
                flag++;
                p1 = flag;
                p2 = 0;
            }
            if (p2 == needle.length()) return flag;
        }
        return -1;
    }

    public int strStrRK(String haystack, String needle) {
        // RK算法
        // 思想：用哈希算法对主串中的n-m+1个字串分别求哈希值，然后逐个与模式串中的哈希值比较大小
        // 设计哈希算法：（1）用26进制表示字符串的哈希值,这种方法的缺点是当模式串长一点的时候，数字就会越界
        // （2）设计有散列冲突的哈希算法，如果有冲突，就对比模式串和主串的子串
        if (needle.length() == 0) return 0;
        int patternLen = needle.length();
        // 映射字母表
        Map<Character, Integer> charMap = new HashMap<>();
        char key = 'a' - 1;
        char end = 'z';
        int value = 1;
        while (key < end) {
            key++;
            charMap.put(key, value++);
        }
        int patternValue = 0;
        for (int i = 0; i < needle.length(); i++) {
            int m = needle.length() - i - 1;
            patternValue += charMap.get(needle.charAt(i)) * Math.pow(26, m);
        }
        System.out.println(patternValue);
        // 哈希值和主串起始下标映射
        Map<Integer, Integer> haystackmap = new HashMap<>();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int hashValue = 0;
            for (int j = 0; j < needle.length(); j++) {
                int m = needle.length() - j - 1;
                System.out.println(m);
                hashValue += charMap.get(haystack.charAt(i + j)) * Math.pow(26, m);
                System.out.println(hashValue);
            }
            if (hashValue == patternValue) return i;
        }
        return -1;
    }

    public int strStrKMP(String haystack, String needle) {
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
                return i - needle.length() + 1;
            }
        }
        return -1;
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

    private static int[] GetNext(String s, int length) {// length为串ch的长度
        int[] next = new int[length+1];
        next[1] = 0;
        int i = 1, j = 0;//i为当前正在匹配的字符位置，也就是next数组的索引
        while (i < length) {
            if (j == 0 || s.charAt(i) == s.charAt(j)) next[++i] = ++j;
            else j = next[j];
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "aaab";
        int[] m = GetNext(s, s.length());
        for (int i = 1; i <= s.length(); i++) {
            System.out.println(m[i]);
        }
    }
}
