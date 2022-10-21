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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        int carry = 0;
        ListNode temp = new ListNode();
        ListNode head = temp;
        while(l1!=null && l2!=null){
            int val = ((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            ListNode inTemp = new ListNode(val);
            temp.next = inTemp;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int val = ((l1.val+carry)%10);
            carry = (l1.val+carry)/10;
            ListNode inTemp = new ListNode(val);
            temp.next = inTemp;
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int val = ((l2.val+carry)%10);
            carry = (l2.val+carry)/10;
            ListNode inTemp = new ListNode(val);
            temp.next = inTemp;
            temp = temp.next;
            l2 = l2.next;
        }
        if(carry!=0){
            ListNode inTemp = new ListNode(1);
            temp.next = inTemp;
            temp = temp.next;
        }
        return head.next;
    }
}