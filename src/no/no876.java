package no;

public class no876 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 有两个中间结点，返回第二个中间结点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 6; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        System.out.println(middleNode(head).val);
    }
    // 测试用例
    // 输入空链表，会不会返回null
    // 输入一个结点的链表，是否会正常输出这个结点
    // 输入两个结点的链表，是否会输出第二个结点
    // 输入三个结点的链表，是否会输出中间结点
    // 输入四个结点的链表，是否会输出第三个结点
    // 输入很长的结点，测试算法的执行效率
}
