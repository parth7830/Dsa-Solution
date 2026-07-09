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
        return build(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }
    private TreeNode build(int[] pre,int[] in,int prestart,int preend,int instart,int inend){
        if(prestart > preend || instart > inend) return null;
        int rootval = pre[prestart];
        TreeNode node = new TreeNode(rootval);
        int inroot = instart;
        while(in[inroot] != rootval) inroot++;
        int leftcount = inroot - instart;
        node.left = build(pre,in,prestart+1,prestart+leftcount,instart,inroot-1);
        node.right = build(pre,in,prestart + leftcount + 1,preend,inroot +1,inend);
        return node;
    }
}