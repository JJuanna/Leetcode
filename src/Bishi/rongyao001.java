package Bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class rongyao001 {
    private static int a[][] = { { 31,28,31,30,31,30,31,31,30,31,30,31 },{ 31,29,31,30,31,30,31,31,30,31,30,31 } };
    private static int b[] = { 0,1,2,3,4,5,6,0 };

    //基姆拉尔森计算公式计算某年某月某日对应的星期
    public static int CaculateWeekDay(int yy, int mm, int d)
    {
        if (mm == 1 || mm == 2) {
            mm += 12;
            yy--;
        }
        int iWeek = (d + 2 * mm + 3 * (mm + 1) / 5 + yy + yy / 4 - yy / 100 + yy / 400) % 7;
        return iWeek + 1;
    }

//注意这里的星期：周日-周六（一周的开始是周日）
    //判断是否是闰年
    public static int IsLeapYear(int y)
    {
        if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0)))
            return 1;
        else return 0;
    }

    public static int CaculateDay(int yy, int mm, int w, int n)
    {
        //输入判断是否符合条件
        if (mm < 1 || mm > 12)return 0;
        if (w < 1 || w > 6)return 0;
        if (n < 1 || n > 7)return 0;
        //计算每月1号星期几------》为下面判断周几是否有：
        //如2019年7月1号是星期一，那么按照周日为一周的开始，则n=7,return 0；CaculateDay函数 按照此逻辑
        //如果周一为一周开始，参考CaculateDay2函数

        int days;
        int week_day = CaculateWeekDay(yy, mm, 1);//计算每月1号星期
        if (w == 1) {
            //第一周需要检查n是否超过
            if (b[n] < b[week_day])
                return 0;
            else
                days = b[n] - b[week_day] + 1;
        }
        else {
            days = b[6] - b[week_day] + 1;
            days += (w - 2) * 7;
            days += (b[n] + 1);
            if (days <= 0 || days > a[IsLeapYear(yy)][mm - 1])
                return 0;
        }
        return days;
    }

    public static int CaculateDay2(int yy, int mm, int w, int n)
    {
        //输入判断是否符合条件
        if (mm < 1 || mm > 12)return 0;
        if (w < 1 || w > 6)return 0;
        if (n < 1 || n > 7)return 0;

        int days;
        int week_day = CaculateWeekDay(yy, mm, 1);//计算每月1号星期
        if (w == 1) {
            //第一周需要检查n是否超过
            if (n < week_day)
                return 0;
            else
                days = n - week_day + 1;
        }
        else {
            days = 7 - week_day + 1;
            days += (w - 2) * 7;
            days += n;
            if (days <= 0 || days > a[IsLeapYear(yy)][mm - 1])
                return 0;
        }
        return days;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int yy = Integer.parseInt(str[0]);
        int mm = Integer.parseInt(str[1]);
        int w = Integer.parseInt(str[2]);
        int n = Integer.parseInt(str[3]);
        int day = CaculateDay2(yy, mm, w, n);
        if (day == 0) System.out.println(day);
        else
        {
            String strm = null;
            String strd = null;
            if(mm<10) {
                strm = "0"+mm;
            }else{
                strm = String.valueOf(mm);
            }
            if(day<10){
                strd = "0"+day;
            }else{
                strd =String.valueOf(day);
            }
            System.out.println(yy+"-"+strm+"-"+strd);
        }
    }
}


