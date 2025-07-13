class Solution {
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode tmpNext = current.next;
            current.next = prev;
            prev = current;
            current = tmpNext;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = getMiddle(head);

        ListNode secondHalf = reverse(mid.next);
        mid.next = null; 

        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode tmp1 = firstHalf.next;
            ListNode tmp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = tmp1;

            firstHalf = tmp1;
            secondHalf = tmp2;
        }
    }
}
