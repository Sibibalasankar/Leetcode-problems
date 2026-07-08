// Last updated: 7/8/2026, 5:01:36 PM
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
    public int pairSum(ListNode head) {

        ListNode temp = head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }   
        int[] arr = new int[n];
        int j=0;
        temp = head;
        while(temp!=null){
            arr[j++] = temp.val;
            temp=temp.next;
        }
        int max = 0;
        for(int i=0;i<n/2;i++){
            max = Math.max(max,arr[i] +  arr[n-1-i]);
        }
        return max;


    }
}