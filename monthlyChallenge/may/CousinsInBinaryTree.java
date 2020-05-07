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
 *
 * Time : O(n + n)
 * Space : O(n) -> Recursion stack
 *
 */
class Solution {
    private class NodeAndDepth {
        private int val;
        private int depth;
        
        public NodeAndDepth(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        
        NodeAndDepth nodex = findNode(root, x, 0);
        NodeAndDepth nodey = findNode(root, y, 0);
        
        if (nodex == null || nodey == null) {
            return false;
        }
        else if (nodex.val == nodey.val) {
            return false;
        } 
        else if (nodex.depth != nodey.depth) {
            return false;
        }
        // System.out.println("Parent of x : " + nodex.val + " at depth : " + nodex.depth);
        // System.out.println("Parent of y : " + nodey.val + " at depth : " + nodey.depth);
        
        return true;
        
    }
    
    public NodeAndDepth findNode(TreeNode root, int x, int k) {
        
        if (root == null) {
            return null;
        }
        
        if ((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)) {
            return new NodeAndDepth(root.val, k);
        }
        
        NodeAndDepth left = findNode(root.left, x, k + 1);
        if (left != null) {
            return left;
        }
        NodeAndDepth right = findNode(root.right, x, k + 1);
        if (right != null) {
            return right;
        }
        
        return null;
        
    }
    
}
