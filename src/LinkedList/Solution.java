package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /**
     * 返回链表中倒数k个节点，要求时间复杂度O(n)，空间复杂度O(1)
     *
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        // 用快慢指针
        // 考虑k>链表长度的情况
        if (pHead == null) return null;
        // 计算链表长度
        ListNode fast = pHead;
        int length = 1;
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }
        if (k == length) return pHead;
        if (k > length) return null;
        fast = pHead;
        for (int i = 0; i < k && fast.next != null; i++) {
            fast = fast.next;
        }
        ListNode slow = pHead;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除链表中倒数第n个节点，n一定是有效的
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        // 快慢指针
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    /**
     * 返回两个链表的第一个公共节点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 双指针
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }

    /**
     * 判断一个链表是否为回文结构：
     * 方法一：用字符串数组或者list存储链表中的值，然后遍历字符串或者链表比较，时间复杂度和空间复杂度都是O(n)
     * 方法二：先遍历找到链表中点位置，然后逆置后半部分链表，用快慢指针对比；遍历一遍链表，将链表中的数据用字符串存储，判断字符串是否是回文结构
     *
     * @param head
     * @return
     */
    public boolean isPail(ListNode head) {
        // write code here
        ListNode p = head;
        // 获取链表长度, 从0开始
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        // 用字符串数组存储
        String[] sb = new String[len];
        int k = 0;
        while (p != null) {
            sb[k++] = String.valueOf(p.val);
            p = p.next;
        }
        for (int i = 0, j = sb.length - 1; i < sb.length / 2; i++, j--) {
            if (!sb[i].equals(sb[j])) return false;
        }
        return true;
    }

    public boolean isPailReverse(ListNode head) {
        if (head == null || head.next == null) return true;
        // 用快慢指针找到链表中点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast不为空，链表长度为奇数，从slow的下一个节点开始反转
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        // 迭代法反转链表
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
     * 链表长度大于等于0小于等于100，节点的值的绝对值小于等于100
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 因为元素大小有序，用双指针遍历，一个指针指向新出现的节点，一个指针遍历链表，找到下一个新的节点，然后跳过这些节点
        if (head == null || head.next == null) return head;
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            if (left.val == right.val) {
                right = right.next;
            } else {
                left.next = right;
                left = right;
                right = right.next;
            }
        }
        // 如果left没有走到链表尾，说明从left之后的节点都是重复的
        if (left.next != null) {
            left.next = null;
        }
        return head;
    }

    /**
     * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicatesPlus(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(1001);//关联题目限定条件
        res.next = head;
        // 将所有相同的元素都跳过
//        ListNode left = res;//指向当前唯一出现的节点
        ListNode right = res;//找下一个唯一出现的节点
        while (right.next != null && right.next.next != null) {
            if (right.next.val == right.next.next.val) {
                int tmp = right.next.val;
                while (right.next != null && right.next.val == tmp) {
                    // 删除操作
                    right.next = right.next.next;
                }
            } else right = right.next;
        }
        return res.next;
    }
    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        p.next = new ListNode(2);
        p.next.next = new ListNode(2);
        ListNode res = deleteDuplicatesPlus(p);
        System.out.println(res.val);
     }
}
