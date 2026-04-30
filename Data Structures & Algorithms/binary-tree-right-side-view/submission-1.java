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
    public List<Integer> rightSideView(TreeNode root) {
        int[]dep = new int[1];
        List<Integer> ans = new ArrayList<>();
        dep[0]=0;
        return help(root,ans,dep,0);
    }
    public List<Integer> help(TreeNode root, List<Integer> ans, int[] dep, int depth){
        if(root==null)
            return ans;
        if(depth>=dep[0]){
            dep[0]+=1;
            ans.add(root.val);
        }
        help(root.right,ans,dep,depth+1);
        help(root.left,ans,dep,depth+1);
        return ans;
    }
}
