package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class MyLinkedList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val;this.next=next;}
    }

    int size;
    ListNode head;
    /*初始化链表*/
    public MyLinkedList(){
        size = 0;
        //  虚拟头节点
        head = new ListNode(0);
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;

        ListNode curr = head;
        // index steps needed
        // to move from sentinel node to wanted index
        for(int i = 0; i < index + 1; ++i) curr = curr.next;
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size) return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0) index = 0;

        ++size;
        // find predecessor of the node to be added
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        // node to be added
        ListNode toAdd = new ListNode(val);
        // insertion itself
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        size--;
        // find predecessor of the node to be deleted
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        // delete pred.next
        pred.next = pred.next.next;
    }
    public void printNode(){
        ListNode p = this.head;
        while(p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }

// "get","addAtHead","addAtIndex","addAtHead"]
//            [4],[4],[5,0],[6]]
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(7);
//        linkedList.printNode();
//        linkedList.addAtHead(2);
//        linkedList.printNode();
//        linkedList.addAtHead(1);
//        linkedList.printNode();
//        linkedList.addAtIndex(3,0);
//        linkedList.printNode();
//        linkedList.deleteAtIndex(2);
//        linkedList.printNode();
//        linkedList.addAtHead(6);
//        linkedList.printNode();
//        linkedList.addAtTail(4);
//        linkedList.printNode();
//        System.out.println(linkedList.get(4));
//        linkedList.printNode();
//        linkedList.addAtHead(4);
//        linkedList.printNode();
//        linkedList.addAtIndex(5,0);
//        linkedList.printNode();
//        linkedList.addAtHead(6);
        linkedList.addAtHead(1);
        linkedList.printNode();
        linkedList.addAtTail(3);
        linkedList.printNode();
        linkedList.addAtIndex(1,2);
        linkedList.printNode();
        System.out.println(linkedList.get(0));
        linkedList.deleteAtIndex(0);
        System.out.println(linkedList.get(0));
        System.out.println();
    }
}
