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
    public TreeNode invertTree(TreeNode root) {
        return help(root);
    }
    public TreeNode help(TreeNode root){
        if(root==null)
            return null;
        else{
            TreeNode temp = root.right;
            root.right = help(root.left);
            root.left = help (temp);
        }
        return root;
    }
}
