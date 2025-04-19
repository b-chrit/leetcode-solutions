import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Successor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { 
            this.val = val; 
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Not on LeetCode -- Level Order Successor
    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(root);

        while (!myQueue.isEmpty()) {
            TreeNode current = myQueue.poll();

            if (current.left != null) myQueue.offer(current.left);
            if (current.right != null) myQueue.offer(current.right);

            if (current.val == key) break;
        }

        return myQueue.peek(); // Will return null if no successor
    }
}
