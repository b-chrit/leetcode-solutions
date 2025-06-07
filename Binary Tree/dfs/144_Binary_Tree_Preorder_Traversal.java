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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);

        return result;
    }

    private void preOrderTraversal(TreeNode root, List<Integer> result){
        if(root == null) return;
        
        result.add(root.val);

        preOrderTraversal(root.left, result);
        preOrderTraversal(root.right, result);
    }
    

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Stack<TreeNode> myStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        myStack.push(root);

        while(!myStack.isEmpty()){
            TreeNode current = myStack.pop();
            result.add(current.val);

            if(current.right != null) myStack.push(current.right);
            if(current.left != null) myStack.push(current.left);
        }

        return result;
    }
}