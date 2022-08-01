package Test;

import org.junit.Test;
import string.ReverseString;
import string.strMatch;

import java.util.HashMap;

public class StringTest {
    @Test
    public void reverseWordsTest(){
        ReverseString rs = new ReverseString();
        String res = rs.reverseWords("the sky is blue");
        System.out.println(res);
    }
    @Test
    public void reverseLeftWordsTest(){
        ReverseString rs = new ReverseString();
        String res = rs.reverseLeftWords("lrloseumgh", 6);
        System.out.println(res);
    }
    @Test
    public void strStrTest(){
        strMatch strstr = new strMatch();
        int res = strstr.strStrRK("ababcaababcaabc","ababcaabc");
        System.out.println(res);
    }
}
