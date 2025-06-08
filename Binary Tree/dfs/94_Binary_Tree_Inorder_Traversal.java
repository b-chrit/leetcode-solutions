class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> myStack = new Stack<>();
        TreeNode current = root;

        while(current != null || !myStack.isEmpty()){

            while(current != null){
                myStack.push(current);
                current = current.left;
            }

            current = myStack.pop();
            result.add(current.val);

            current = current.right;
        }

        return result;
    }
}