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
        int n = 0;
        ListNode curr = head;
        while(curr!=null){
            n++;
            curr=curr.next; 
        }
        curr = head;
        ListNode prev = null;
        for(int i = 0; i<n/2;i++){
            prev=curr;
            curr=curr.next;
        }
        ListNode middle = curr;
        if ((n & 1) == 0) {
            prev.next = null;
        } else {
            ListNode secondStart = middle.next;
            middle.next = null;
            middle = secondStart; 
        }

        ListNode rev = null;
        while (middle != null) {
            ListNode temp = middle.next;
            middle.next = rev;
            rev = middle;
            middle = temp;
        }
        ListNode first = head, second = rev;
        while(second!=null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
}
