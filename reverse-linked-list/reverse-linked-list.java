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
    public static ListNode tail= null;
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode first = head;
        ListNode second= null;
        recursive(first,second);
        return tail;
    }
    public void recursive(ListNode first, ListNode second){
        if(first.next == null){
            tail= first;
            return;
        }
        second = first;
        first = first.next;
        recursive(first,second);
        first.next = second;
        second.next = null;
    }
}