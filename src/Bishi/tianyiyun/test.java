package Bishi.tianyiyun;

import BinaryTree.TreeNode;

import java.util.Stack;

// 求二叉树叶子节点的平均高度
public class test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        System.out.println(averageHeight(root));
    }

    public static double averageHeight(TreeNode pRoot) {
        if (pRoot == null) return 0.0;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode pNode = pRoot;
        s2.push(pNode);
        double max = 0.0;
        int count = 0;
        int height = 0;
        while (!s1.empty() || !s2.empty()) {
            s1 = s2;
            while (!s2.empty()) {
                pNode = s2.pop();
                if (pNode.left == null && pNode.right == null) {
                    count++;
                    max += height;
                }
            }

            while (!s1.empty()) {
                pNode = s1.pop();
                if (pNode.left != null)
                    s2.push(pNode.left);
                if (pNode.right != null)
                    s2.push(pNode.right);
            }
            height++;
        }
        System.out.println(max);
        System.out.println(count);
        return max / count;

    }

}
