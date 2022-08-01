package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        // 递归方法(深度优先)：从根节点开始翻转
        // 先序遍历方法，时间复杂度O(n),空间复杂度O(logn)(递归栈)，最坏情况下，树为链式的时候，空间复杂度是O(n)
        // 根-左-右
        // 根
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 反转左
        root.left = invertTree(root.left);
        // 反转右
        root.right = invertTree(root.right);
        return root;
    }
    // 迭代方式(广度优先)，利用队列实现
    // O(n),O(n)
    public TreeNode iterativelyInvertTree(TreeNode root){
        if(root==null) return null;
        // queue和deque都是接口，linkedlist是实现queue和deque接口的一个类
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode p = deque.remove();
            if(p.left != null) deque.add(p.left);
            if(p.right != null) deque.add(p.right);
            TreeNode tmp = p.left;
            p.left = p.right;
            p.right = tmp;
        }
        return root;
    }
}
