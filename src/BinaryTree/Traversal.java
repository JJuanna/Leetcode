package BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Traversal {
    List<Integer> res = new ArrayList<>();

    // 二叉树前序、中序、后序递归遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        // 前序遍历：根->左->右
        preorderSearch(root);
        return res;
    }

    public void preorderSearch(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        if (root.left != null) preorderTraversal(root.left);
        if (root.right != null) preorderTraversal(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderSearch(root);
        return res;

    }

    public void inorderSearch(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inorderTraversal(root.left);
        res.add(root.val);
        if (root.right != null) inorderTraversal(root.right);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        postorderSearch(root);
        return res;

    }

    public void postorderSearch(TreeNode root) {
        if (root == null) return;
        if (root.left != null) postorderSearch(root.left);
        if (root.right != null) postorderSearch(root.right);
        res.add(root.val);
    }

    // 二叉树前中后序迭代遍历
    // 用栈实现迭代遍历
    public List<Integer> preorderIterativeTraversal(TreeNode root) {
        // 前序遍历：根->左->右
        // 入栈的顺序需要是右->左，才可以保证出栈的顺序是左->右
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            res.add(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return res;
    }

    public List<Integer> inorderIterativeTraversal(TreeNode root) {
        // 中序遍历：左->根->右
        // 和前序遍历相比，中序遍历的访问顺序和处理顺序是不一样的，中序遍历先访问到树左面最底部，然后再处理节点
        // 因此，在使用迭代法写中序遍历的时候，需要借助指针的遍历来帮助访问节点，栈用来处理节点上的元素
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public List<Integer> postIterativeTraversal(TreeNode root) {
        // 后序遍历：左->右->根,前序是根->左->右,出栈顺序根->右->左
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            res.add(p.val);
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
    // 统一迭代法


    // 二叉树的层序遍历
    // 层序遍历思路：用队列实现,时间复杂度O(n),空间复杂度O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.add(p);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                p = queue.remove();
                tmp.add(p.val);
                // 进栈子孩子
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
                size--;
            }
            res.add(tmp);
        }
        return res;
    }

    // 二叉树的右视图，在二叉树右侧看到的节点顶部到底部的节点
    // 思路：层序遍历保留每一层最后一个节点
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.add(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 1) {
                p = queue.remove();
                // 进栈子孩子
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
                size--;
            }
            p = queue.remove();
            res.add(p.val);
            if (p.left != null) queue.add(p.left);
            if (p.right != null) queue.add(p.right);
        }
        return res;
    }

    // 二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.add(p);
        while (!queue.isEmpty()) {
            // 两个int相加可能会溢出
            long sum = 0;
            int size = queue.size();
            double divide = size;
            while (size > 0) {
                p = queue.remove();
                sum += p.val;
                // 进栈子孩子
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
                size--;
            }
            res.add(sum/divide);
        }
        return res;
    }

    // 每个树行中找最大值
    // 填充每个节点的下一个右侧节点指针
}
