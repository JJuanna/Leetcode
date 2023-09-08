package BinaryTree;

import javafx.scene.shape.VLineTo;
import sun.reflect.generics.tree.Tree;

/**
 * 给定一个树的根节点，判断树的子节点的值是否等于根节点的值
 * 遍历一遍树，树中节点的总和=2*根节点的值
 */
public class checkTree {
    public static boolean checkTree(TreeNode root) {
        if (root.left == root.right) return true;
        int value = checkTreeNode(root, 0);
        return value == root.val * 2;
    }

    public static int checkTreeNode(TreeNode root, int value) {
        // 递归前序遍历的方法
        value += root.val;
        if (root.left != null) {
            value = checkTreeNode(root.left, value);
        }
        if (root.right != null) {
            value = checkTreeNode(root.right, value);
        }
        return value;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(checkTree(root));

    }
}
