import java.util.ArrayList;
import java.util.List;

public class PathSum2_113 {

    public class TreeNode {
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
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, result, new ArrayList<Integer>());

        return result;
    }
    public static void dfs(TreeNode root, int target, List<List<Integer>> result, List<Integer> path) {
        // base case
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            result.add(new ArrayList<Integer>(path));
        }

        dfs(root.left, target - root.val, result, path);
        dfs(root.right, target - root.val, result, path);
        path.remove(path.size() - 1);
    }
}
