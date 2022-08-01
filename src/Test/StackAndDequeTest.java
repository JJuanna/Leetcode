package Test;

import StackAndDeque.EvalReversePolishNotation;
import org.junit.Test;

public class StackAndDequeTest {
    @Test
    public void testPolish(){
        EvalReversePolishNotation solution = new EvalReversePolishNotation();
        String[] tokens = {"4","13","5","/","+"};
        int res = solution.evalRPN(tokens);
        System.out.println(res);
    }
}
