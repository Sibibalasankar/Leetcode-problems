# Last updated: 7/8/2026, 5:03:24 PM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == "null" or head.next == "null" :
            return null
        temp = head
        n = 0
        while temp:
            n+=1
            temp = temp.next
        
        pos = math.floor(n/2)
        temp = head
        curr = 0
        while curr != pos:
            temp = temp.next
            curr+=1
        head = temp 
        return head

