class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        Node clone = new Node(node.val);
        visited.put(node, clone);
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    Node neighborClone = new Node(neighbor.val);
                    visited.put(neighbor, neighborClone);
                    stack.push(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }

        return clone;
    }
}
