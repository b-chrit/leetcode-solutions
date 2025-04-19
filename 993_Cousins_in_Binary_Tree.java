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
    private int xDepth = -1;
    private int yDepth = -1;
    private TreeNode xParent = null;
    private TreeNode yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        findDepthAndParent(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    private void findDepthAndParent(TreeNode node, int x, int y, int depth, TreeNode parent) {
        if (node == null) return;
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        }
        if (node.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        findDepthAndParent(node.left, x, y, depth + 1, node);
        findDepthAndParent(node.right, x, y, depth + 1, node);
    }
}
