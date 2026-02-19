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
      return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(slow);
        ListNode ans = merge(head1,head2);
        return ans;
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode ansNode = new ListNode(-1);
        ListNode ansTail = ansNode;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                ansTail.next = new ListNode(head1.val);
                head1 = head1.next;
            }else{
               ansTail.next = new ListNode(head2.val);
                head2 = head2.next;  
            }
            ansTail = ansTail.next;
        }
         if (head1 != null) {
            ansTail.next = head1;
        } else {
            ansTail.next = head2;
        }

        return ansNode.next;
    }
}