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
    private void lo(TreeNode root,List<List<Integer>> al){
        if(root == null)return;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> al1 = new ArrayList<>();
            for(int i = 0;i<size;i++){
            TreeNode Node = qu.poll();
            al1.add(Node.val);
            if(Node.left != null) qu.offer(Node.left);
            if(Node.right != null) qu.offer(Node.right);
            }
            al.add(al1);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        lo(root,al);
        return al;
    }
}