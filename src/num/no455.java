package num;

public class no455 {
    public int findContentChildren(int[] g, int[] s) {
        int res=0;
        for(int i=0;i<g.length;i++){
            for(int j=0;j<s.length;j++){
                if(g[i]<=s[j]) {
                    res++;
                    s[j]=0;
                }
                break;
            }
        }
        return res;
    }
}
