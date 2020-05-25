/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        
        if (preorder == null || preorder.length == 0)
            return null;
        
        TreeNode root = createBST(preorder, 0, preorder.length - 1);
        
        return root;
        
    }
    
    public TreeNode createBST(int[] preorder, int rootId, int endId) {
        
        if (rootId < 0 || rootId > preorder.length - 1) return null;
        
        TreeNode node = new TreeNode(preorder[rootId]);
        
        if (rootId >= endId) return node;
        
        int leftSubTreeRootId = -1;
        int rightSubTreeRootId = -1;
        
        for (int i = rootId + 1; i <= endId; i++) {
            if (preorder[rootId] < preorder[i]) {
                rightSubTreeRootId = i;
                break;
            }
        }
        
        if (rootId + 1 != rightSubTreeRootId) leftSubTreeRootId = rootId + 1;
        
        int lastId = rightSubTreeRootId == -1 ? endId : rightSubTreeRootId - 1;
        
        node.left = createBST(preorder, leftSubTreeRootId, lastId);
        node.right = createBST(preorder, rightSubTreeRootId, endId);
        
        return node;
        
    }    
    
}
