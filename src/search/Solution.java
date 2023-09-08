package search;

public class Solution {
    /**
     * 二维数组中的查找
     * 解法：由于矩阵
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n-1;
        while (i<m && j>=0){
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else return true;
        }
            return false;
    }
}
