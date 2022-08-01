package nowcoder;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

/*  问题:有n个回合，每一个回合修改字符串中的一个字母，n个回合结束后，字符串中重复数最多的字母的数量为每个人的得分，
    找胜利的一个人(输出胜利的一个人的名字)或多个人(输出draw)*/
/*  思路:(1)先统计初始字符串中每个字符串出现的次数;(2)value(次数+回合)>=value(字符串长度)？(得分=字符串长度):(得分=字符众数的数量+回合数)
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String xiaoming = sc.next();
        String xiaowang = sc.next();
        String xiaoli = sc.next();
        int modeming = Math.min(getMode(xiaoming) + n, xiaoming.length());
        int modewang = Math.min(getMode(xiaowang) + n, xiaowang.length());
        int modeli = Math.min(getMode(xiaoli) + n, xiaoli.length());
//      有无平局？有，返回draw:无，找唯一获胜者
        if(modeming==modewang && modeming>modeli ||modeming==modeli && modeming>modewang||modewang==modeli&&modewang>modeli||modeming==modewang&&modeming==modeli) System.out.println("draw");
        else{
            if(modeming>Math.max(modewang,modeli)) System.out.println("xiaoming");
            if(modewang>Math.max(modeming,modeli)) System.out.println("xiaowang");
            if(modeli>Math.max(modewang,modeming)) System.out.println("xiaoli");

        }

    }
    public static int getMode(String s){
        int mode = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            mode = Math.max(mode, map.get(c));
        }
        return mode;
    }
}
