package Bishi;

import java.util.Scanner;

public class huaweimian0002 {

    public static void main(String[] args) {
        //如果是奇数，肯定满足条件
        int num;
        Scanner sc= new Scanner(System.in);
        num = sc.nextInt();
        if(num%2==1){
            System.out.println("YES");
        }
        //如果是偶数
        /**
         *
         * 设输入的数值n为奇数，2k+1，那么奇数肯定能化成k+k+1，所以肯定是输出yes。
         如果输入的数值n为偶数，要稍微复杂些。
         反证，假设这个偶数能被换成连续自然数相加形式。
         那么可以有x+(x+1)+(x+2)+……+(x+k) == n,
         用等差数列求和公式，求出(2x+k)(k+1)/2 == n,
         若k+1为偶数，则2x+k为奇数，若k+1为奇数，则2x+k为偶数，所以必定有一奇数和一个偶数。
         我们把公式转换成(2x+k)(k+1) == 2n，因为2n是偶数，左边(2x+k)(k+1)一定有一个数值为偶数。
         等式两边不断提取因数2，如果2n可以不断提取因数2化成2^m，也就是2的幂，
         而等式的左边因为存在一个奇数，(2x+k)(k+1)是不能化成2^m。所以式子两边不可能相等。
         所以2的幂是不能转换成连续自然数相加的形式。
         但是没有直接证明偶数可以拆成什么具体形式。
         所以这题只是钻了题目的空子，同类型的题目好像还要输出连续自然数的序列。所以这题可以直接判定n是否为2的幂即可。
         *  */
        else if((num & (num-1))==0){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }

    }




}
