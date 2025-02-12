/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Check if list is null or not
        if (lists == null || lists.length == 0) {
            return null;
        }
        // Create Priority Queue of ListNode with Custom Comparator
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Traverse in full lists and Adding them in PriorityQueue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        // Create Another Listnode as a Temp while we will return at last
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        // Due to Priority Queue it will only return small value node and Point out
        // these node to temp node
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if (node.next != null) {
                pq.add(node.next);

            }
        }

        return dummy.next;
    }
}