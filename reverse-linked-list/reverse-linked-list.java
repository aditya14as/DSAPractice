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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode third = null;
        ListNode second = head;
        ListNode first = head.next;
        while(first!=null){
            second.next = third;
            third = second;
            second = first;
            first = first.next;
        }
        second.next = third;
        return second;
    }
}