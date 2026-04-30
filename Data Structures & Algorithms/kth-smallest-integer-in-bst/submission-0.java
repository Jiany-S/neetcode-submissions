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
    public int kthSmallest(TreeNode root, int k) {
        int[] temp = new int[]{k};
        return help(root,temp);
    }
    public int help(TreeNode root, int[] temp){
        if(root==null)
            return 0;
        int t = help(root.left,temp);
        temp[0]--;
        if(temp[0]==0)
            return root.val;
        return help(root.right,temp)+t;
    }
}
