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
    public ListNode partition(ListNode head, int x) {
        ListNode big= new ListNode(0);
        ListNode small=new ListNode(0);
        ListNode temp=head;
        ListNode nh = small;
        ListNode bh = big;
        while(temp!=null){
            if(temp.val<x){
                small.next=temp;
                small = small.next;
            }else{
                big.next=temp;
                big = big.next;
            }
             temp=temp.next;
        }
        small.next = bh.next;
        big.next = null;
        return nh.next;
        
    }
}