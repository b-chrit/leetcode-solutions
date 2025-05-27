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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        while (lists.length > 1) {
            int newLength = (lists.length + 1) / 2;
            ListNode[] newLists = new ListNode[newLength];

            for (int i = 0; i < lists.length; i += 2) {
                if (i + 1 < lists.length) {
                    newLists[i / 2] = merge(lists[i], lists[i + 1]);
                } else {
                    newLists[i / 2] = lists[i];
                }
            }

            lists = newLists;
        }

        return lists[0];
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }
}
