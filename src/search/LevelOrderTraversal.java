package search;

import java.util.*;

/**
 * @author Zeller
 * @Link <a href=" https://leetcode.com/problems/binary-tree-level-order-traversal/"> </a>
 * @Description
 * @Date 2018/11/26
 **/
public class LevelOrderTraversal {
    public static void main(String[] args) {

    }

    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();
                curLevel.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(curLevel);
        }
        return res;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
