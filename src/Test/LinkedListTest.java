package Test;

import LinkedList.Cycle;
import LinkedList.ListNode;
import org.junit.Test;

public class LinkedListTest {
    @Test
    public void detectCycle(){
        Cycle solution = new Cycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;


        ListNode ret = solution.detectCycle(head);
        System.out.println(ret);

    }
}
