package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class treeDP {
    // 结合后续遍历
    // 记忆化递推，用一个map保存已经计算过的节点的值
    private Map<TreeNode, Integer> map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (map.containsKey(root)) return map.get(root); // 如果umap里已经有记录则直接返回
        // 偷父节点
        int val1 = root.val;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right); // 跳过root->left
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right); // 跳过root->right
        // 不偷父节点
        int val2 = rob(root.left) + rob(root.right); // 考虑root的左右孩子
        map.put(root, Math.max(val1, val2));
        return Math.max(val1, val2);
    }

    public int dpRob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robAction(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        // 偷左孩子
        int[] left = robAction(root.left);
        // 偷右孩子
        int[] right = robAction(root.right);

        // 不偷根节点
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷根节点，不偷左右孩子
        res[1] = root.val + left[0]+right[0];

        return res;
    }
}
