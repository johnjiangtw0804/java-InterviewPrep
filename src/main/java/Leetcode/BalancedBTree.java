package Leetcode;

public class BalancedBTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        return balance;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = dfs(root.left);
        int rightH = dfs(root.right);
        if (Math.abs(leftH - rightH) > 1) {
            balance = false;
        }
        return Math.max(leftH, rightH) + 1;
    }
}
