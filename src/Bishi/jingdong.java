package Bishi;

// 用先序遍历还原二叉树，用-1表示空结点
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class jingdong {
    public static void main(String[] args) {
        int[] nums = {1,2,-1,3};
        int n = nums.length;
        TreeNode root = createTree(nums, 0);
        System.out.println(root.left.right.val);
    }


    static TreeNode createTree(int[] nums, int pos) {
        int n = nums.length;
        if (pos >= n || nums[pos] == -1) return null;
        TreeNode root = new TreeNode();
        root.val = nums[pos];
        if (pos < n) {
            root.left = createTree(nums, ++pos);
            root.right = createTree(nums, ++pos);
        }
        return root;
    }

}
