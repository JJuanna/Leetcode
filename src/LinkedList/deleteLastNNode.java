package LinkedList;


public class deleteLastNNode {

    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val;this.next=next;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 双指针法
        // 初始情况：fast=slow=head;
        // 三种情况:(1)删除头节点(2)删除末尾节点(3)删除中间节点
        // 删除头节点：fast会遍历完链表,head=head.next
        // 删除末尾节点：和删除中间节点一样的操作
        // 时间复杂度O(n),空间复杂度O(1)
        ListNode fast=head, slow=head;
        while(n>0){
            fast = fast.next;
            n--;
        }
        // 如果fast==null,说明要删除的是头节点，
        if(fast==null) {
            head = head.next;
            return head;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
