package BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class serializeBinaryTree {
    // 用广度优先搜索实现树的序列化,序列化和反序列化的时间复杂度都是O(N)，空间复杂度都是O(N)
    StringBuilder res;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        res = new StringBuilder("[");
        if(root==null) return "[]";
        TreeNode p = root;
        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(p);
        while(!deque.isEmpty()){
            // 出栈
            p = deque.poll();
            // 如果p不为null,添加p的左右孩子
            if(p!=null){
                res.append(p.val+",");
                deque.add(p.left);
                deque.add(p.right);
            }
            else{
                res.append("null,");
            }
        }
        // 删除最后的逗号
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }
    public static void main(String[] args){
        serializeBinaryTree s = new serializeBinaryTree();
        // 创建一课树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        String ret = s.serialize(root);
        System.out.println(ret);
    }
}
