package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zeller
 * @Link <a href=" https://leetcode.com/problems/maximum-depth-of-binary-tree/"> </a>
 * @Description
 * @Date 2018/11/26
 **/
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        int cur = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            cur++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

            }

        }
        return cur;
    }

    //递归的方法
    public int minDepthByDivide(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepthByDivide(root.right);
        if (root.right == null) return 1 + minDepthByDivide(root.left);

        int leftMinDepth = minDepthByDivide(root.left);
        int rightMinDepth = minDepthByDivide(root.right);
        int result = 1 + Math.min(leftMinDepth, rightMinDepth);
        return result;
    }

    //深度优先搜索
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int cur = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            cur++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                if (treeNode.right == null && treeNode.left == null) {
                    return cur;
                }
            }
        }
        return cur;
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
