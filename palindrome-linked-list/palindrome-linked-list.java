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
    public boolean isPalindrome(ListNode head) {
        if(head ==null || head.next == null) return true;
        ListNode temp1 = head;
        ListNode temp2 = middle(head);
        ListNode revNode = reverse(temp2);
        while(revNode!=null && temp1!=null){
            if(revNode.val != temp1.val){
                return false;
            }
            revNode = revNode.next;
            temp1 = temp1.next;
        }
        return true;
        
    }
    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            slow= slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode after = head.next;
        while(current!=null){
            current.next = prev;
            prev = current;
            current = after;
            if(after!=null){
                after = after.next;
            }
        }
        return prev;
    }
}