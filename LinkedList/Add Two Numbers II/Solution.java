//445. Add Two Numbers II
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1=reverse(l1);
        ListNode curr2=reverse(l2);
        int carry=0;
        ListNode ans=new ListNode(0);
        ListNode ptr=ans;
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
            ptr.next=new ListNode(sum%10);
            ptr=ptr.next;
            carry=sum/10;
        }
        return reverse(ans.next);
    }
    public ListNode reverse(ListNode l1){
        ListNode rev=null;
        ListNode curr=l1;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=rev;
            rev=curr;
            curr=temp;
        }
        return rev;
    }
}
