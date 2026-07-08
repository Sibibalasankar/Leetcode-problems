// Last updated: 7/8/2026, 5:05:16 PM
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head; //slow pointer to head
        ListNode fast=head; //fast pointer
        //detect whether a cycle exist or not 
        while(fast!=null && fast.next!=null){
            slow=slow.next; //move slow one step
            fast=fast.next.next;//move fast two step
            if(slow==fast){ //cycle exist when they meet
                slow=head; //reset slow to head and remain fast to meeting point
                while(slow!=fast){ //move both pointer one step and
                //when they meet again thats our starting point of cycle 
                    slow=slow.next; 
                    fast=fast.next; 
                }
                return slow;//cycle entry found so return 
            }
        } 
        return null;//no cycle 
    } 
} 