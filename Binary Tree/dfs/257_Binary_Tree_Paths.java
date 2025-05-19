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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        
        if(root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }
        
        List<String> leftTree = binaryTreePaths(root.left);
        for(String path : leftTree) {
            result.add(root.val + "->" + path);
        }
        
        List<String> rightTree = binaryTreePaths(root.right);
        for(String path : rightTree) {
            result.add(root.val + "->" + path);
        }
        
        return result;
    }
}