package Dyanamic_programming;
import Binary_Tree.TreeNode;
public class LT_124_BinaryTreeMaxPathSum {
    static int ans;
    public static int maxLineSum(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, maxLineSum(node.left));   // discard negative paths
        int right = Math.max(0, maxLineSum(node.right));

        int pathSumThroughNode = node.val + left + right;
        ans = Math.max(ans, pathSumThroughNode);

        return node.val + Math.max(left, right); // return one side to parent
    }
    public static int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        maxLineSum(root); // no need to use the return value
        return ans;
    }


    public static void main(String[] args) {

    }
}
