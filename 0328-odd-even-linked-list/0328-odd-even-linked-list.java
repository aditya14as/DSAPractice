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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode o = head;
        ListNode e = head.next;
        ListNode eh = head.next;
        while(e!=null && e.next!=null){
            o.next = o.next.next;
            e.next = e.next.next;
            o = o.next;
            e = e.next;
        }
        o.next = eh;
        return head;
    }
}