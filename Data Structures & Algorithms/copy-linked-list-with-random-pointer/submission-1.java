/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node copy = new Node(head.val);
        Node curr = head.next;
        Node dummy = new Node(0);
        dummy.next = copy;
        HashMap<Node,Node> map = new HashMap<>();
        map.put(head,copy);
        while(curr!=null){
            copy.next = new Node(curr.val);
            copy = copy.next;
            map.put(curr,copy);
            curr = curr.next;
        }
        copy = dummy.next;
        curr = head;
        while(copy!=null){
            if(curr.random==null){
                copy.random=null;
            }
            else if(map.containsKey(curr.random)){
                copy.random = map.get(curr.random);
            }
            else{
                copy.random = new Node (curr.random.val);
            }
            curr = curr.next;
            copy = copy.next;
        }
        return dummy.next;
    }
}
