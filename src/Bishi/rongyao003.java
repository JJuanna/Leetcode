package Bishi;

import java.util.Arrays;
import java.util.Scanner;

public class rongyao003 {

    private static final int maxn = 100000 + 50;
    private static int[] c=new int[maxn];

    private static int lowbit(int x) {
        return x & (-x);
    }

    private static void update(int x,int y,int n){
        for(int i=x;i<=n;i+=lowbit(i))    //x为更新的位置,y为更新后的数,n为数组最大值
            c[i] += y;
    }
    private static int getsum(int p) {
        if(p == 0)
            return 0;
        int res = 0;
        while(p>0) {
            res += c[p];
            p -= lowbit(p);
        }
        return res;
    }
    private static int[] num = new int[maxn];

    public static void main(String[] args) {
        int t;
        int MAXN = 100000 + 4;
        Scanner sc= new Scanner(System.in);
        t = sc.nextInt();
        while(t-->0)
        {
            Arrays.fill(num, 0);
            Arrays.fill(c, 0);
            int n;
            n = sc.nextInt();
            int maxx = -1;
            int sum = 0;
            int x;
            for(int i = 0; i < n; i++)
            {
                x = sc.nextInt();
                int t1 = getsum(x - 1);
                int t3 = getsum(MAXN);
                t3 -= num[x];
                int t2 = t3 - t1;
                sum += (t1 - t2);
                maxx = Math.max(maxx,sum);
                num[x]++ ;
                update(x,1,MAXN);
            }
            System.out.println(maxx+" "+sum);
        }
    }
//    int main()
//    {
//        int t;
//        int MAXN = 1e5 + 4;
//        scanf("%d",&t);
//        while(t--)
//        {
//            memset(num,0,sizeof num);
//            memset(c,0,sizeof c);
//            int n;
//            scanf("%d",&n);
//            int maxx = -1;
//            int sum = 0;
//            int x;
//            for(int i = 0; i < n; i++)
//            {
//                scanf("%d",&x);
//                int t1 = getsum(x - 1);
//                int t3 = getsum(MAXN);
////            cout << t3 << endl;
//                t3 -= num[x];
//                int t2 = t3 - t1;
////            printf("%d %d %d\n",t1,t2,t3);
//                sum += (t1 - t2);
//                maxx = max(maxx,sum);
//                num[x]++ ;
////            cout << num[x] << " sdf " << endl;
//                update(x,1,MAXN);
//            }
//            printf("%d %d\n",maxx,sum);
//        }
//        return 0;
//    }

}
