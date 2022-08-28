package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class BuildTreeNode {


    // 给定一个字符串数组，字符串数组按层存储，构建二叉树
    public static TreeNode buildBinaryTree(String[] arrays) {
        // 用队列模拟
        Deque<TreeNode> que = new LinkedList<>();
        que.add(new TreeNode(Integer.parseInt(arrays[0])));
        TreeNode root = que.peek();
        int index = 0;
        while (!que.isEmpty()) {
            TreeNode cur = que.remove();
            if (index + 2 < arrays.length && !arrays[index + 1].equals("null") && !arrays[index + 2].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(arrays[index+1]));
                TreeNode right = new TreeNode(Integer.parseInt(arrays[index+2]));
                cur.left = left;
                cur.right = right;
                que.add(left);
                que.add(right);
                index += 2;
            } else if (index + 2 < arrays.length && Objects.equals(arrays[index + 1], "null") && !Objects.equals(arrays[index + 2], "null")) {
                TreeNode right = new TreeNode(Integer.parseInt(arrays[index = index + 2]));
                cur.right = right;
                que.add(right);
            } else if (index + 2 < arrays.length && !Objects.equals(arrays[index + 1], "null") && Objects.equals(arrays[index + 2], "null")) {
                TreeNode left = new TreeNode(Integer.parseInt(arrays[index = index + 1]));
                cur.left = left;
                que.add(left);
            }
            else {
                // 左右都为null
                // 不进行操作，index跳过两个null
                index = index+2;
            }
        }
        return root;
    }

    // 递归遍历树
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        if (root.left != null) {
            preorder(root.left);
        }
        if (root.right != null) {
            preorder(root.right);
        }
    }


    public static void main(String[] args) {
        String[] str = new String[]{"3", "9", "20", "null", "null", "15", "7"};
        TreeNode root = buildBinaryTree(str);
        //  前序遍历树
        preorder(root);
    }
}
