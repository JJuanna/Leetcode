package LinkedList;

import java.util.*;

public class LRUCache {
    // 构建双头链表
    class DListNode{
        int key;
        int value;
        DListNode prev;
        DListNode next;
        public DListNode(){}
        public DListNode(int _key, int _value){
            key = _key;
            value = _value;
        }
    }
    // 缓存容量
    // 缓存当前size
    // 映射map,映射每一个node的key和位置，实现访问每个node的时间复杂度为1
    private int capaticy;
    private int curSize;
    private Map<Integer, DListNode> map = new HashMap<Integer, DListNode>();
    private DListNode head, tail;

    public LRUCache(int capacity) {
        // 初始化LRU缓存
        this.curSize = 0;
        this.capaticy = capacity;
        // 使用伪头部node和尾部node
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    // 访问页面
    public int get(int key) {
        // 如果map中存在key, 将key对应的DListNode移到链表末尾
        // 如果map中不存在key, 返回-1
        if(map.keySet().contains(key)){
            // 将key对应的DListNode添加到双向链表末尾
            DListNode cur = map.get(key);
            moveToTail(cur);
            return cur.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 链表中已经有key
        if(map.keySet().contains(key)){
            //
            DListNode cur = map.get(key);
            cur.value = value;
            // 将当前节点从当前位置移动到链表尾
            moveToTail(cur);
            // 链表中没有key,缓存容量满
        }else if(this.curSize==capaticy){
            // 将链表的实际头节点删除
            DListNode delete = head.next;
            removeNode(head.next);
            map.remove(delete.key);
            System.out.println("remove"+delete.key);
            DListNode add = new DListNode(key, value);
            addToTail(add);
            map.put(key, add);
        }else if(this.curSize<capaticy){
            DListNode add = new DListNode(key, value);
            addToTail(add);
            map.put(key, add);
        }

    }

    // 链表的操作
    // 在尾部添加（缓存中没有待添加节点的时候）
    public void addToTail(DListNode add){
        DListNode tailPrev = tail.prev;
        tailPrev.next = add;
        add.prev = tailPrev;
        add.next = tail;
        tail.prev = add;
        this.curSize++;
        System.out.println("添加add"+add.key+add.value);
        System.out.println("当前size"+this.curSize);
    }
    public void removeNode(DListNode cur){
        DListNode curPrev = cur.prev;
        DListNode curNext = cur.next;
        curPrev.next = curNext;
        curNext.prev = curPrev;
        this.curSize--;
        System.out.println("删除cur"+cur.key+cur.value);
        System.out.println("当前size"+this.curSize);
    }
    private void moveToTail(DListNode node) {
        removeNode(node);
        addToTail(node);
    }

    public static void main(String[] args) {
//        int capacity = 2;
//        LRUCache obj = new LRUCache(capacity);
//        obj.put(1, 1);
//        obj.put(2, 2);
//        int param_1 = obj.get(1);
//        System.out.println(param_1);
//        obj.put(3, 3);
//        int param_2 = obj.get(2);
//        System.out.println(param_2);
//        obj.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        obj.get(1);    // 返回 -1 (未找到)
//        obj.get(3);    // 返回 3
//        obj.get(4);

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1,1);
        map.put(1,2);
        System.out.println(map.get(1));
    }




}
