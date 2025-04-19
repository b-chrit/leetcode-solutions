
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> myDeque = new LinkedList<>();
        boolean reverse = false;

        myDeque.addLast(root);

        while(!myDeque.isEmpty()){
            int size = myDeque.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < size; i++){
                if(!reverse){
                    TreeNode current = myDeque.pollFirst();
                    currentLevel.add(current.val);

                    if(current.left != null) myDeque.addLast(current.left);
                    if(current.right != null) myDeque.addLast(current.right);
                }else{
                    TreeNode current = myDeque.pollLast();
                    currentLevel.add(current.val);
                    
                    if(current.right != null) myDeque.addFirst(current.right);
                    if(current.left != null) myDeque.addFirst(current.left);
                }
            }

            result.add(currentLevel);
            reverse = !reverse;
        }

        return result;
    }
}
