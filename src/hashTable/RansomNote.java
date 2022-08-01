package hashTable;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    // 通过哈希表映射magazine
    // 时间复杂度O(n),空间复杂度O(n)
    // 哈希表要维护红黑树或哈希表，而且还要做哈希函数，因此当数据量大的时候，使用数组更加高效
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c : ransomNote.toCharArray()){
            if(map.containsKey(c)){
                int temp = map.get(c);
                if(temp>0){
                    map.put(c,temp-1);
                }
                else return false;
            }
            else return false;
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        // 记录杂志中字母出现的次数
        int[] map = new int[26];
        int temp;
        for(int i=0;i<magazine.length();i++){
            temp = magazine.charAt(i)-'a';
            map[temp]++;
        }
        for(int i=0; i<ransomNote.length();i++){
            temp = ransomNote.charAt(i)-'a';
            if(map[temp]>0){
                map[temp]--;
            }
            else return false;
        }
        return true;
    }
}
