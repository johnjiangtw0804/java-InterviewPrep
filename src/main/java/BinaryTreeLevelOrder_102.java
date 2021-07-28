import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder_102 {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);

        return result;
    }
    public void dfs(TreeNode root, List<List<Integer>> result, int level) {
         if (root == null) {
             return;
         }
         if (level == result.size()) {
             result.add(new ArrayList<>());
         }
         result.get(level).add(root.val);
         dfs(root.left, result, level + 1);
         dfs(root.right, result, level + 1);
    }
}
