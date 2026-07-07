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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root,0,0});
        while(!queue.isEmpty()){
            Object[] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int hd = (int) curr[1];
            int level = (int) curr[2];
            map.putIfAbsent(hd,new ArrayList<>());
            map.get(hd).add(new int[]{level,node.val});
            if(node.left != null){
                queue.offer(new Object[]{node.left,hd-1,level+1});
            }if(node.right != null){
                queue.offer(new Object[]{node.right,hd+1,level+1});
            }

        }
        for(List<int[]> nodes : map.values()){
            nodes.sort((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> column = new ArrayList<>();
            for(int[] node : nodes){
                column.add(node[1]);
            }
            res.add(column);
        }
        return res;
    }
}