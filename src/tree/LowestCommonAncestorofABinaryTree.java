package tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author Zeller
 * @Link <a href=" https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/"> </a>
 * @Description 二叉树的最近公共祖先
 * root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * @Date 2018/11/22
 **/
public class LowestCommonAncestorofABinaryTree {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 普通二叉树
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    /**
     * 搜索二叉树
     *
     * @return
     */
    public TreeNode lowestCommonAncestorBinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            //都小于root节点，去左子树继续查找
            return lowestCommonAncestorBinarySearchTree(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            //都大于root节点，去右子树继续查找
            return lowestCommonAncestorBinarySearchTree(root.right, p, q);
        } else {
            //一大一小，说明root节点即为最近公共节点
            return root;
        }
    }




}
