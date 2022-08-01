package BinaryTree;

public class Solution {
    /*
     * 求二叉树的最大直径
     * 直径的定义：任意两个节点路径长度的最大值
     * 任意两个节点，最大直径
     * */
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        System.out.println(L);
        System.out.println(R);
        System.out.println(ans);
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    // 检查二叉树是否对称
    // 解题思路：递归法和迭代解法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        return judge(p, q);
    }

    public boolean judge(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        return p.val == q.val && judge(p.left, q.right) && judge(p.right, q.left);
    }
    // 迭代法判断对称二叉树
    // 两两入队列和出队列
}
