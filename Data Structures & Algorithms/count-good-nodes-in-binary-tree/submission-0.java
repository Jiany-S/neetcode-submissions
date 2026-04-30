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
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        return help(root,root.val,count)[0];
    }
    public int[] help(TreeNode root, int max, int[] count){
        if(root==null)
            return count;
        if(root.val>=max){
            count[0]++;
            max = root.val;
        }
        help(root.left,max,count);
        help(root.right,max,count);
        return count;
    }
}
