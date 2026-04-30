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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode init,ans;
        if(curr1.val>curr2.val){
            init = curr2;
            ans = curr2;
            curr2= curr2.next;
        }
        else{
            init = curr1;
            ans = curr1;
            curr1 = curr1.next;
        }
        while(curr1!=null&&curr2!=null){
            if(curr1.val>curr2.val){
                init.next = curr2;
                init = init.next;
                curr2 = curr2.next;
            }
            else{
                init.next = curr1;
                init = init.next;
                curr1 = curr1.next;
            }
        }
        init.next = (curr1 != null) ? curr1 : curr2;
        return ans;
    }
}