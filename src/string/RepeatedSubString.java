package string;

public class RepeatedSubString {
    /*
     * 给定一个非空字符串s,检查是否可以通过它的一个字串重复多次构成
     * 时间复杂度O(m),空间复杂度O(m)
     * */
    public boolean repeatedSubstringPattern(String s) {
        // 找最小重复子串
        // 求next数组的过程
        int[] next;
        next = getNext(s);
        if (next[s.length()] != -1 && s.length() % (s.length() - next[s.length() - 1] - 1) == 0) {
            return true;
        }
        return false;
    }

    public int[] getNext(String s) {
        int[] next = new int[s.length()];
        int j = -1;
        next[0] = -1;
        for (int i = 1; i < s.length(); i++) {
            // 如果s[j+1]!=s[i],那么回退j
            while (j != -1 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j - 1];
            }
            // 如果s[j+1] == s[i],移动j指针
            if (s.charAt(j + 1) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        for (int key : next) {
            System.out.print(key + " ");
        }
        return next;
    }
}
