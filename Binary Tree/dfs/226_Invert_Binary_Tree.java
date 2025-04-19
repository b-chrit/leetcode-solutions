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
    public TreeNode invertTree(TreeNode root) {
        // if(root == null) return root;

        // Stack<TreeNode> myStack = new Stack<>();
        // myStack.push(root);

        // while(!myStack.isEmpty()){
        //     TreeNode current = myStack.pop();
        //     TreeNode temp = current.left;
        //     current.left = current.right;
        //     current.right = temp;

        //     if(current.left != null) myStack.push(current.left);
        //     if(current.right != null) myStack.push(current.right);
        // }

        // return root;

        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;
        
        return root;
    }
}