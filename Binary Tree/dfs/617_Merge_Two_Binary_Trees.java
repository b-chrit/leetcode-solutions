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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        
        return merged;
    }

    // iterative solution - less efficient
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        Queue<TreeNode> resultQ = new LinkedList<>();
        
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        
        q1.offer(root1);
        q2.offer(root2);
        resultQ.offer(newRoot);
        
        while (!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            TreeNode resultNode = resultQ.poll();

            if (node1 != null && node1.left != null || node2 != null && node2.left != null) {
                int leftVal = 0;
                if (node1 != null && node1.left != null) leftVal += node1.left.val;
                if (node2 != null && node2.left != null) leftVal += node2.left.val;
                
                resultNode.left = new TreeNode(leftVal);
                resultQ.offer(resultNode.left);
                
                q1.offer(node1 != null ? node1.left : null);
                q2.offer(node2 != null ? node2.left : null);
            }
            
            if (node1 != null && node1.right != null || node2 != null && node2.right != null) {
                int rightVal = 0;
                if (node1 != null && node1.right != null) rightVal += node1.right.val;
                if (node2 != null && node2.right != null) rightVal += node2.right.val;
                
                resultNode.right = new TreeNode(rightVal);
                resultQ.offer(resultNode.right);
                
                q1.offer(node1 != null ? node1.right : null);
                q2.offer(node2 != null ? node2.right : null);
            }
        }
        
        return newRoot;
    }
}
