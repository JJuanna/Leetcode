package Bishi;

import java.util.Arrays;

class Solution {

    public static String addBoldTag(String s, String[] dict) {
        if (s == null || s.length() == 0 || dict == null || dict.length == 0) {
            return s;

        }

        boolean[] mark = new boolean[s.length()];
        for (String word : dict) {
            for (int i = 0; i <= s.length() - word.length(); i++) {
                if (s.startsWith(word, i)) {
                    Arrays.fill(mark, i, i + word.length(), true);

                }

            }

        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < mark.length) {
            if (mark[i]) {
                sb.append("**");
                while (i < mark.length && mark[i]) {
                    sb.append(s.charAt(i++));

                }

                sb.append("**");

            } else {
                sb.append(s.charAt(i++));

            }

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(addBoldTag("aaabbcc", new String[]{"aaa","aab","bc"}));
    }

}