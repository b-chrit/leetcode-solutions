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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root.left);
        myQueue.offer(root.right);

        while (!myQueue.isEmpty()) {
            TreeNode left = myQueue.poll();
            TreeNode right = myQueue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;

            myQueue.offer(left.left);
            myQueue.offer(right.right);
            myQueue.offer(left.right);
            myQueue.offer(right.left);
        }

        return true;
    }
}
