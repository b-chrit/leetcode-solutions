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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> rootOneLeaves = new ArrayList<>();
        List<Integer> rootTwoLeaves = new ArrayList<>();

        getRootLeaves(root1, rootOneLeaves);
        getRootLeaves(root2, rootTwoLeaves);

        if(rootOneLeaves.size() != rootTwoLeaves.size()) return false;

        for(int i = 0; i < rootOneLeaves.size(); i++){
            if(!rootOneLeaves.get(i).equals(rootTwoLeaves.get(i))) return false;
        }

        return true;
    }

    private void getRootLeaves(TreeNode root, List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null) list.add(root.val);

        getRootLeaves(root.left, list);
        getRootLeaves(root.right, list);
    }
}