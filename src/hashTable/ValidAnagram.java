package hashTable;

import java.util.*;

public class ValidAnagram {
    /*
     * 两个字符串中每个字母出现的次数相同，那么s和t是字母异位词，返回true
     * 时间复杂度O(n),空间复杂度O(n)
     * */
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 比较两个哈希表
        if (mapS.size() != mapT.size()) return false;
        // 比较两个哈希表的key是否完全相同
        // if(!mapS.keySet().containsAll(mapT.keySet())) return false;
        Set ss = mapS.keySet();
        Set st = mapT.keySet();
        if(!ss.equals(st)) return false;
        for (Character key : mapS.keySet()) {
            // 两个哈希表size相同但是key不相同的情况
            if ((mapS.get(key)-mapT.get(key))!=0) {
                return false;
            }
        }
        return true;
    }


    /*
    * 用数组记录每个字符出现的次数,s中的字符,每出现一次+1,t中的字符每出现一次-1,最后遍历数组，如果有!=0的数字，说明s和t存在出现次数不一样的字母
    * 时间复杂度O(n),空间复杂度O(1)
    * */
    public static boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] record = new int[26];
        for(char c: s.toCharArray()){
            record[c-'a'] += 1;
        }
        for(char c: t.toCharArray()){
            record[c-'a'] -= 1;
        }
        for(int i: record){
            if(i!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();
        System.out.println(isAnagram(first, second));
    }
}
