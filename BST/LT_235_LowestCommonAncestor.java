package BST;
import Binary_Tree.TreeNode;
public class LT_235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
    public static void main(String[] args) {

    }
}
