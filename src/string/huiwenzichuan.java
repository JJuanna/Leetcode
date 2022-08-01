package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个字符串，这个字符串可以打乱顺序排列，找到每个排列的回文子串的个数里面最大的一个
 * */
public class huiwenzichuan {

    List<String> rec;
    boolean[] vis;

    public String[] permutation(String s) {
        int n = s.length();
        rec = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }

    public static void main(String[] args) {
        huiwenzichuan method = new huiwenzichuan();
        String[] res = method.permutation("abca");
        int[] count = new int[res.length];
        int index = 0;
        for(String s :res){
            count[index++] = method.countSubstrings(s);
        }
        int re = Integer.MIN_VALUE;
        for(int i=0;i<count.length;i++){
            if(count[i]>re){
                re = count[i];
            }
        }
        System.out.println(re);
    }

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

}
