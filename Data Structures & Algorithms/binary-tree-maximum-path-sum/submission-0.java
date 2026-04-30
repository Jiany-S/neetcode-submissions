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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{root.val};
        help(root,max);
        return max[0];
    }
    public int help(TreeNode root, int[] max){
        if(root==null)
            return 0;
        int l =Math.max(0,help(root.left,max));
        int r =Math.max(0,help(root.right,max));
        max[0] = Math.max(max[0],root.val+l+r);
        return root.val+Math.max(l,r);
    }
}
