package no;

import BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

import static BinaryTree.BuildTreeNode.buildBinaryTree;

public class no104 {
    public static int maxDepth(TreeNode root) {
        // 迭代法计算深度
        // 使用队列BFS
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.add(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while(size-->0) {
                TreeNode cur = que.remove();
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"3", "9", "20", "null", "null", "15", "7"};
        TreeNode root = buildBinaryTree(str);
        int depth = maxDepth(root);
        System.out.println(depth);
    }

}
