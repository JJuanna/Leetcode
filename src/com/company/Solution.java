package com.company;

import java.util.Deque;

//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode p = head;
        ListNode pre=p, nxt=p.next;
        while(p.next != null){
            if(p.val==val) {
//                删除首结点
                if(pre == p) {
                    p = nxt;
                    head = p;
                }
                else{
                    pre.next = nxt;
                }
            }
//           更新指针
            pre = p;
            p = p.next;
            nxt = p.next;
        }
        return head;
    }
}
