package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class nChildrenTree {
    // n叉树的层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int queueSize = queue.size();
            while(queueSize>0){
                Node cur = queue.remove();
                tmp.add(cur.val);
                queueSize--;
                for(Node i:cur.children){
                    queue.add(i);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
