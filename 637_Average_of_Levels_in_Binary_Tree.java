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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            double currentLevel = 0.0;
            for(int i = 0; i < size; i++){
                TreeNode current = myQueue.poll();
                currentLevel += current.val;

                if(current.left != null) myQueue.offer(current.left);
                if(current.right != null) myQueue.offer(current.right);
            }
            currentLevel = currentLevel / size;
            result.add(currentLevel);
        }

        return result;
    }

    // Not on leetcode -- Level Order Successor
    public TreeNode findSuccessor(TreeNode root, int key){
        if(root == null) return root;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);

        while(!myQueue.isEmpty()){
            TreeNode current = myQueue.poll();

            if(current.left != null) myQueue.offer(current.left);
            if(current.right != null) myQueue.offer(current.right);

            if(current.val == key) break;
        }

        return myQueue.peek();
    }
}