class Solution {
    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // store inorder indices for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(postorder, inorder,
                     0, postorder.length - 1,
                     0, inorder.length - 1);
    }

    private TreeNode build(int[] post, int[] in,
                           int ps, int pe,
                           int is, int ie) {       // fix 2: ie not in
        if (ps > pe || is > ie) return null;

        int rootVal   = post[pe];                  // fix 3: last of postorder
        TreeNode node = new TreeNode(rootVal);

        int inRoot    = inMap.get(rootVal);         // fix 4: find in inorder
        int leftCount = inRoot - is;               // fix 5: now correct

        // fix 6: build children and return
        node.left  = build(post, in,
                           ps, ps + leftCount - 1,         // left postorder
                           is, inRoot - 1);                // left inorder

        node.right = build(post, in,
                           ps + leftCount, pe - 1,         // right postorder
                           inRoot + 1, ie);                // right inorder

        return node;
    }
}