package Test;
import org.junit.Test;
import search.binarySearch;
import array.minSubArrayLen;
import array.SprialMatrix;

public class searchTest {
    @Test
    public void binarySearchTest(){
        int[] nums = {-1,0,3,5,9,12};
        binarySearch search = new binarySearch();
        int index =  search.search(nums, 9);
        System.out.println(index);
    }

    @Test
    public void minSubArrayTest(){
        int[] nums = {1,2,3,4,5};
        int target = 11;
        minSubArrayLen m = new minSubArrayLen();
        int res = m.solution(target, nums);
        System.out.println(res);
    }
    @Test
    public void SprialMatrixTest(){
        int n = 5;
        SprialMatrix s = new SprialMatrix();
        int[][] m = new int[n][n];
        m = s.generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
}
