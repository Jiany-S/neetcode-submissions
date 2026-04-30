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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "N";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return help(data, new int[]{0});
    }
    public TreeNode help(String data, int[] ind){
        if(ind[0]>=data.length())
            return null;
        String temp="";
        while(ind[0]<data.length()&&data.charAt(ind[0])!=','){
            temp+=data.charAt(ind[0]++)+"";
        }
        ind[0]++;
        TreeNode ans = null;
        if(!temp.equals("N")){
            ans = new TreeNode (Integer.parseInt(temp));
        }
        else
            return null;
        ans.left = help(data,ind);
        ans.right = help(data,ind);
        return ans;
    }
}
