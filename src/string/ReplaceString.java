package string;

public class ReplaceString {

    /*
    * 把字符串的每个空格替换成%20
    * */
    public String replaceSpace(String s) {
        char[] c = new char[s.length()*3];
        int size = 0;
        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            if(x==' '){
                c[size++] = '%';
                c[size++] = '2';
                c[size++] = '0';
            }
            else{
                c[size++] = x;
            }
        }
        String newStr = new String(c, 0, size);
        return newStr;
    }

}
