package array;

public class SprialMatrix {
    /*
     * input:int n
     * output: n*n matrix,矩阵需要满足要求：顺时针螺旋排列1~n^2的元素
     * 时间复杂度O(n^2),空间复杂度O(n^2)
     * */
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int top = 0, bottem = n - 1, left = 0, right = n - 1;
        int pad = 1, target = n*n;
        while (pad <= target) {
            // 从左到右
            for(int i=left; i<=right; i++) m[top][i] = pad++;
            top++;
            // 从上到下
            for(int i=top; i<=bottem; i++) m[i][right] = pad++;
            right--;
            // 从右到左
            for(int i=right; i>=left; i--) m[bottem][i] = pad++;
            bottem--;
            // 从下到上
            for(int i = bottem; i>=top; i--) m[i][left] = pad++;
            left++;
        }
        return m;
    }
}
