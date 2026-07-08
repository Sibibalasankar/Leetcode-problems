// Last updated: 7/8/2026, 5:05:50 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return is_Mirror(root.left,root.right);
    }


    public boolean is_Mirror(TreeNode n1,TreeNode n2){
        if(n1 == null && n2 == null) return true;

        if(n1 == null || n2 == null) return false;

        return n1.val == n2.val && is_Mirror(n1.left,n2.right) && is_Mirror(n1.right,n2.left);
    }
}