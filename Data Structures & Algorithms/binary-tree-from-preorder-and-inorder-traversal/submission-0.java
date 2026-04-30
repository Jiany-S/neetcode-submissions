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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,new int[]{0},0,preorder.length-1,map);
    }
    public TreeNode build(int[] preorder, int[] inorder,int[] pre, int l, int r, HashMap<Integer,Integer> map ){
        if(pre[0]==preorder.length||l>r)
            return null;
        int i = map.get(preorder[pre[0]]);
        TreeNode ans = new TreeNode(preorder[pre[0]++]);
        ans.left = build(preorder,inorder,pre,l,i-1,map);
        ans.right = build(preorder,inorder,pre,i+1,r,map);
        return ans;

    }
}
