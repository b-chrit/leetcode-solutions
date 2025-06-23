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
    public int size(ListNode head){
        int size = 0;
        while(head != null){
            head = head.next;
            size+=1;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        if(size == n){
            return head.next;
        }
        ListNode prev = null; 
        ListNode current = head;
        while(current != null){
            if(size == n){
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;
            size-=1;
        }
        return head;
    }
}
