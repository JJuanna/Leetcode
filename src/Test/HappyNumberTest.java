package Test;

import hashTable.HappyNumber;
import hashTable.TwoSum;
import org.junit.Test;

public class HappyNumberTest {
    @Test
    public void testHappyNumber(){
        System.out.println(HappyNumber.isHappy(19));
    }
    @Test
    public void testTwoSum(){
        int[] res;
        int[] input = {3,3};
        res = TwoSum.twoSum(input,7);
        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }
}
