class BrowserHistory {
    Node current;
    
    private class Node {
        String value;
        Node next;
        Node prev;
        
        Node(String value) {
            this.value = value;
        }
    }
    
    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        current.next = node;
        node.prev = current;
        current = node;
        // Clear forward history - any nodes after current are unreachable
    }
    
    public String back(int steps) {
        for(int i = 0; i < steps && current.prev != null; i++) {
            current = current.prev;
        }
        return current.value;
    }
    
    public String forward(int steps) {
        for(int i = 0; i < steps && current.next != null; i++) {
            current = current.next;
        }
        return current.value;
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */