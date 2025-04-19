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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
   List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);

        while(!myQueue.isEmpty()){
            int levelSize = myQueue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode current = myQueue.poll();
                currentLevel.add(current.val);

                if(current.left != null) myQueue.add(current.left);
                if(current.right != null) myQueue.add(current.right);
            }
            result.add(0, currentLevel);
        }

        return result;
    }
}