class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> myStack = new Stack<>();
        List<TreeNode> myList = new ArrayList<>();

        myStack.push(root);

        while (!myStack.isEmpty()) {
            TreeNode current = myStack.pop();
            myList.add(current);

            if (current.right != null) myStack.push(current.right);
            if (current.left != null) myStack.push(current.left);
        }

        for (int i = 0; i < myList.size() - 1; i++) {
            TreeNode curr = myList.get(i);
            TreeNode next = myList.get(i + 1);
            curr.left = null;
            curr.right = next;
        }
    }
}
