// Last updated: 7/8/2026, 5:04:37 PM
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null){
            return null;
        }
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        int count = 1;
        ListNode temp=head;

        while(temp!=null){
            if(count%2!=0){
                odd.add(temp.val);
            }else{
                even.add(temp.val);
            }
            count++;
            temp = temp.next;
        }
        temp = head;
        odd.addAll(even);
        for(int i=0;i<odd.size();i++){
            int num = odd.get(i);
            temp.val = num;
            temp=temp.next;
        }

        for(int i=odd.size();i<even.size();i++){
            int num =even.get(i);
            temp.val = num;
            temp=temp.next;
        }

    return head;

    }
}