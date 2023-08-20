package no;

import java.util.HashMap;
import java.util.Map;

class ListNode {
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

public class no1171 {
    // 使用前缀和的方法，遍历链表两次
    // 第一次，得到链表的前缀和哈希表，覆盖前缀和相同的哈希表记录
    // 第二次，将跳过和前面节点具有相同前缀和的节点
    public static ListNode removeZeroSumSublists(ListNode head) {
        // 哈希表
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> seen = new HashMap<>();
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            seen.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = seen.get(prefix).next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        ListNode now = p;
        int[] nums = new int[]{1, 2, 3, -3, 1};
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            now.next = temp;
            now = temp;
        }
        ListNode newP = removeZeroSumSublists(p);
        for(ListNode node=newP; node!=null; node=node.next){
            System.out.println(node.val);
        }

    }
}
