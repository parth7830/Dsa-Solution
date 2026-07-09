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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder,inorder,0,postorder.length - 1,0,inorder.length-1);
    }
    private TreeNode build(int[] post,int[] ie,int ps,int pe,int is,int in){
        if(ps > pe || is > in) return null;
        int rootval = post[pe];
        TreeNode node = new TreeNode(rootval);
        int inroot = is;
        while(ie[inroot] != rootval) inroot++;
        int leftcount = inroot - is;
        node.left = build(post,ie,ps,ps+leftcount-1,is,inroot -1);
        node.right = build(post,ie,ps+leftcount,pe - 1,inroot+1,in);
        return node;
    }
}