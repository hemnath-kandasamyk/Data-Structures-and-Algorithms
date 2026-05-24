//2. Add Two Numbers
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode curr1=l1;
       ListNode curr2=l2;
       ListNode dummy=new ListNode(0);
       ListNode res=dummy;
       int carry=0;
       while(curr1!=null || curr2!=null || carry!=0){
           int sum=carry;
           if(curr1!=null){
               sum+=curr1.val;
               curr1=curr1.next;
           }
           if(curr2!=null){
               sum+=curr2.val;
               curr2=curr2.next;
           }
           res.next=new ListNode(sum%10);
           carry=sum/10;
           res=res.next;
       } 
        return dummy.next;
    }
}
