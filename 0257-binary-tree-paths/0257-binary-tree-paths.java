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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> al = new ArrayList<>();
        if(root == null) return al;
        dfs(root,"",al);
        return al;
    }
    private void dfs(TreeNode root,String path,List<String> al){
        if(path.isEmpty()){
            path = String.valueOf(root.val);
        }else{
            path = path + "->" + root.val;
        }
        if(root.left == null && root.right == null){
            al.add(path);
            return;
        }
        if(root.left != null) dfs(root.left,path,al);
        if(root.right != null) dfs(root.right,path,al);
    }
}