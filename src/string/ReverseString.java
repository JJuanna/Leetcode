package string;

public class ReverseString {
    /*
    * 原地反转字符串
    * 双指针
    * */
    public void reverseString(char[] s) {
        int left=0, right=s.length-1;
        while(left<=right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /*
    * 给定一个字符串和一个整数k，每计数2k个字符，就反转前k个字符
    * 如果字符长度<k,将字符全部反转
    * 如果字符长度<2k,但>k,则反转前k个字符
    * 时间复杂度O(n),空间复杂度O(n)
    * */
    public String reverseStr(String s, int k) {
        // 字符串转为字符数组
        char[] arrayS = s.toCharArray();
        for(int i=0; i<s.length(); i+=2*k){
            int start = i;
            int end = Math.min(arrayS.length-1, start+k-1);
            while(start<end){
                // 用异或运算交换两个字符
                arrayS[start] ^= arrayS[end];
                arrayS[end] ^= arrayS[start];
                arrayS[start] ^= arrayS[end];
                start++;
                end--;
            }
        }
        return new String(arrayS);
    }

    /*
    * 翻转字符串里的单词的顺序
    * 时间复杂度O(n), 空间复杂度O(n)
    * */
    public String reverseWords(String s) {
        // 删除多余空格
        StringBuilder sb = removeSpace(s);
        s = sb.toString();
        // 反转单词
        char[] c = new char[s.length()];
        int left = s.length()-1, right = s.length()-1;
        int count = 0;
        while(count<s.length()){
            // 找空格
            while(s.charAt(left)!=' ' && left>0) left--;
            if(left==0) left=-1;
            for(int i=left+1; i<=right; i++){
                c[count++] = s.charAt(i);
            }
            // 加一个空格
            if(count!=s.length()) c[count++] = ' ';
            // 更新指针
            right = left-1;
            left = left-1;
        }
        return new String(c);
    }
    // 去除首尾以及中间多余的空格
    public StringBuilder removeSpace(String s){
        // 先去掉首尾的空格
        int start = 0;
        int end = s.length()-1;
        while(s.charAt(start)==' ') start++;
        while(s.charAt(end)==' ') end--;
        StringBuilder sb = new StringBuilder();
        // 去掉中间的空格
        while(start <= end){
            char c = s.charAt(start);
            if( c != ' ' || sb.charAt(sb.length()-1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /*
    * 左旋转字符串
    * */
    public String reverseLeftWords(String s, int n) {
        // substring左闭右开
        // StringBuilder sb = new StringBuilder(s.substring(0, n));
        // StringBuilder sb2 = new StringBuilder(s.substring(n, s.length()));
        // sb2.append(sb.toString());
        // return sb2.toString();
        // 如果不能用stringbuilder和substring
        // 不申请额外的空间
        // 1.反转区间前n的字符串
        // 2.反转区间n到末尾的字符串
        // 3.反转整个字符串
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n-1);
        reverseString(sb, n, sb.length()-1);
        reverseString(sb, 0, sb.length()-1);
        return sb.toString();

    }

    public void reverseString(StringBuilder sb, int start, int end){
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
