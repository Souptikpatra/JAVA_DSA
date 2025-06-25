package Dyanamic_programming;
import Binary_Tree.TreeNode;

import java.util.HashMap;

public class LT_543_DiameterOfBinaryTree {

    // without memoization

//    // Utility function to find maximum of three integers
//    public int max(int a, int b, int c) {
//        return Math.max(a, Math.max(b, c));
//    }
//
//    // Function to find the height (level) of a binary tree
//    public int level(TreeNode root) {
//        if (root == null) return 0; // Base case: empty node has height 0
//        int leftLevel = level(root.left); // Recursively find height of left subtree
//        int rightLevel = level(root.right); // Recursively find height of right subtree
//        return 1 + Math.max(leftLevel, rightLevel); // Height = 1 + max(left, right)
//    }
//
//    // Main function to calculate the diameter of the binary tree
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0; // Base case: diameter of empty tree is 0
//        // Diameter passing through the current root
//        int myDia = (level(root.left) + level(root.right) + 1) - 1; // nodes - 1 = edges
//        int leftDia = diameterOfBinaryTree(root.left); // Diameter in the left subtree
//        int rightDia = diameterOfBinaryTree(root.right); // Diameter in the right subtree
//        return max(myDia, leftDia, rightDia);  // The overall diameter is the maximum of the three
//    }


    // with memoization

    // Utility function to find maximum of three integers
    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    HashMap<TreeNode,Integer> memo; // we will store  level and its corresponding node in this Hashmap
    public int level(TreeNode root) {
        if (root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root); // memo check
        int leftLevel = level(root.left);
        int rightLevel = level(root.right);
        int ans = 1 + Math.max(leftLevel, rightLevel);
        memo.put(root,ans); // update memo
        return ans;
    }

    public int helper(TreeNode root){
        if (root == null) return 0;
        int myDia = (level(root.left) + level(root.right) + 1) - 1; // nodes - 1 = edges
        int leftDia = helper(root.left);
        int rightDia = helper(root.right);
        return max(myDia, leftDia, rightDia);
    }
    public int diameterOfBinaryTree(TreeNode root) {
       memo = new HashMap<>();
       return helper(root);
    }

    public static void main(String[] args) {

    }
}
