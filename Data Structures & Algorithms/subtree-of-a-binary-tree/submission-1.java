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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        boolean temp = false;
        if(subroot==null)
            return true;
        if(root==null)
            return false;
        if(root.val==subroot.val){
            temp =isSameTree(root,subroot);
        }
        return isSubtree(root.left,subroot)||isSubtree(root.right,subroot)||temp;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        else if((p==null&&q!=null)||(q==null&&p!=null)||(p.val!=q.val))
            return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
