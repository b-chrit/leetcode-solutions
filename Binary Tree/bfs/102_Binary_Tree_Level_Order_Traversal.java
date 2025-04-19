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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> myList = new ArrayList<>();
        if(root == null) return myList;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode current = myQueue.poll();
                currentLevel.add(current.val);

                if(current.left != null) myQueue.offer(current.left);
                if(current.right != null) myQueue.offer(current.right);

            }

            myList.add(currentLevel);
        }

        return myList;
    }
}