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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        return help(root,ans,0);
    }
    public List<List<Integer>> help (TreeNode root, List<List<Integer>> ans, int depth){
        if(root==null)
            return ans;
        if(depth>=ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(root.val);
        help(root.left,ans,depth+1);
        help(root.right,ans,depth+1);
        return ans;
    }

}
