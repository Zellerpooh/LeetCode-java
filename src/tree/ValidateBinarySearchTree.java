package tree;

/**
 * @author Zeller
 * @Link <a href="https://leetcode.com/problems/validate-binary-search-tree/description/"> </a>
 * @Description 验证二叉搜索树
 * @Date 2018/11/21
 **/
public class ValidateBinarySearchTree {

    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
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
