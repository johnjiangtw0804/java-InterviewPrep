public class BinaryTreeLongestConSeq_298 {
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
    private int result = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // current max
        int max = 1;
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.left != null && root.left.val == root.val + 1) {
            left++;
        } else {
            left = 1;
        }
        if (root.right != null && root.right.val == root.val + 1)  {
            right++;
        } else {
            right = 1;
        }

        max = Math.max(left, right);
        result = Math.max(result, max);
        return  max;
    }
}
