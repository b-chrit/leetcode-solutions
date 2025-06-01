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
    private int currentPreorderPosition = 0;
    
    public TreeNode buildTree(int[] preorderTraversal, int[] inorderTraversal) {
        return constructTreeFromTraversals(preorderTraversal, inorderTraversal, 0, inorderTraversal.length - 1);
    }
    
    private TreeNode constructTreeFromTraversals(int[] preorderTraversal, int[] inorderTraversal, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        
        int currentRootValue = preorderTraversal[currentPreorderPosition++];
        TreeNode currentRoot = new TreeNode(currentRootValue);
        
        int rootPositionInInorder = -1;
        for (int position = inorderStart; position <= inorderEnd; position++) {
            if (inorderTraversal[position] == currentRootValue) {
                rootPositionInInorder = position;
                break;
            }
        }
        
        currentRoot.left = constructTreeFromTraversals(preorderTraversal, inorderTraversal, inorderStart, rootPositionInInorder - 1);
        currentRoot.right = constructTreeFromTraversals(preorderTraversal, inorderTraversal, rootPositionInInorder + 1, inorderEnd);
        
        return currentRoot;
    }
}