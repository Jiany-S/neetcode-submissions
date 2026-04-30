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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len  = 0;
        ListNode curr = head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        curr = head;
        ListNode prev = dummy;
        int n = 0;
        while(len>=k){
            curr = prev.next;
            ListNode next = curr.next;
            for(int i = 1; i<k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            len -= k;
        }
        return dummy.next;
    }
}
