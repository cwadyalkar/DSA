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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = reverseList(slow.next);
        ListNode l1  = head;
        slow.next = null;
        
        merge(l1,l2);


    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head = prev;
        return prev;
    }
    public void merge(ListNode l1, ListNode l2){
        while(l2 != null){
            ListNode listn1 = l1.next;
            ListNode listn2 = l2.next;

            l1.next = l2;
            l2.next = listn1; 

            l1 = listn1;
            l2  = listn2;
        }
    }
}