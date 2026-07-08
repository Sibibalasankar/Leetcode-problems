// Last updated: 7/8/2026, 5:01:31 PM
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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)return null;
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }

        int pos = (int) Math.ceil(n/2);

        temp = head;
        int curr = 0;

        while(curr!=pos-1){
            temp = temp.next;
            curr++;
        }


        temp.next = temp.next.next;


        return head;
    }
}