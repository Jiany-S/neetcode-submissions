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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int sz = 0;
        while(curr!=null){
            sz++;
            curr = curr.next;
        }
        if(n==sz){
            return head.next;
        }
        curr = head;
        for (int i = 1; i < sz-n; i++){
            curr = curr.next;
        }
        if(curr.next==null){
            return null;
        }
        curr.next=curr.next.next;
        return head;
    }
}
