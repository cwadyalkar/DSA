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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preLeft = dummy;
        ListNode currNode = head;

        for(int i = 0;i < left-1;i++){
            preLeft = preLeft.next;
            currNode = currNode.next;
        }
        ListNode subList = currNode;
        ListNode preNode = null;
        for(int i = 0;i <= right-left;i++){
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        preLeft.next = preNode;
        subList.next = currNode;

        return dummy.next;

    }
}