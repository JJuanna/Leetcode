package LinkedList;

public class Cycle {

    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        // 返回链表的入口节点
        // 先判断是否有环
        // 再找入口节点
        // 返回相遇节点
        ListNode ret = hasCycle(head);
        // 找入口节点
        if(ret != null){
            ListNode p = head;
            while (p != ret) {
                p = p.next;
                ret = ret.next;
            }
            return p;
        }
        return null;
    }

    public ListNode hasCycle(ListNode head) {
        // 只有一个节点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return fast;
        }
        return null;
    }
}
