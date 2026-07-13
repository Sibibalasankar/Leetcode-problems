// Last updated: 7/13/2026, 9:19:23 PM
1class Solution {
2    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
3        ListNode dummy = new ListNode();
4        ListNode cur = dummy;
5
6        while (list1 != null && list2 != null) {
7            if (list1.val > list2.val) {
8                cur.next = list2;
9                list2 = list2.next;
10            } else {
11                cur.next = list1;
12                list1 = list1.next;
13            }
14            cur = cur.next;
15        }
16
17        cur.next = (list1 != null) ? list1 : list2;
18
19        return dummy.next;        
20    }
21}