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
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);

        while(!myQueue.isEmpty()){
            int levelSize = myQueue.size();
            int currentLevelSum = 0;

            for(int i = 0; i < levelSize; i++){
                TreeNode current = myQueue.poll();
                currentLevelSum += current.val;

                if(current.left != null) myQueue.offer(current.left);
                if(current.right != null) myQueue.offer(current.right);
            }

            if(currentLevelSum > maxSum){
                maxSum = currentLevelSum;
                maxLevel = level;
            }
            
            level++;
        }

        return maxLevel;
    }
}