/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }
 private ListNode getMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }
    private ListNode merge(ListNode list1, ListNode list2){
        ListNode h1 = list1;
        ListNode h2 = list2;

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                tail.next = h1;
                h1 = h1.next;
            }else{
                tail.next = h2;
                h2 = h2.next;
            }

            tail = tail.next;
        }

        if(h1 != null){
            tail.next = h1;
        }else{
            tail.next = h2;
        }

        return dummy.next;
    }
}