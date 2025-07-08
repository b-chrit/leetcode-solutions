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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        if (root.left == null && root.right == null) return 1;
        
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        
        if (root.left == null) return rightMin + 1;
        if (root.right == null) return leftMin + 1;
        
        return Math.min(leftMin, rightMin) + 1;
    }
}

/* 
 * Key difference from maxDepth:
 * 
 * MaxDepth can use Math.max(left, right) + 1 because Math.max() naturally ignores 
 * null paths (depth 0) and picks the longest valid path.
 * 
 * MinDepth CANNOT use Math.min(left, right) + 1 because Math.min() would pick 
 * null paths (depth 0), giving incorrect results. We must reach an actual LEAF NODE.
 * 
 * Example: Tree [1,2,null] - minDepth should be 2, not 1.
 * The explicit null checks ensure we only traverse paths that lead to real leaves.
 */
