//92. Reverse Linked List II
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      ListNode dummy=new ListNode(0);
      dummy.next=head;
      ListNode curr=dummy;
      for(int i=1;i<left;i++){
        curr=curr.next;
      }
      ListNode rev=null;
      ListNode temp=curr.next;
      ListNode endptr=null;
      while(temp!=null && left<=right){
        ListNode prev=temp.next;
        temp.next=rev;
        rev=temp;
        temp=prev;
        if(rev!=null && rev.next==null){
            endptr=rev;
        }
        left++;
      }
      curr.next=rev;
      endptr.next=temp;
      return dummy.next;
    }
}
