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
        if(lists==null||lists.length==0)
            return null;
        for(int i = 1; i<lists.length; i++){
            ListNode dummy = new ListNode();
            ListNode curr1 = lists[i-1];
            ListNode curr2 = lists[i];
            if(curr1.val<curr2.val){
                dummy.next = curr1;
                curr1=curr1.next;
            }
            else{
                dummy.next = curr2;
                curr2=curr2.next;
            }
            ListNode curr = dummy.next;
            while(curr1!=null&&curr2!=null){
                if(curr1.val<curr2.val){
                    curr.next = curr1;
                    curr1 = curr1.next;
                    curr = curr.next;
                }
                else{
                    curr.next = curr2;
                    curr2 = curr2.next;
                    curr = curr.next;
                }
            }
            if(curr1==null){
                curr.next = curr2;
            }
            else
                curr.next=curr1;
            lists[i]=dummy.next;
        }
        return lists[lists.length-1];
    }
}
