//61. Rotate List
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        int length=1;
        ListNode curr=head;
        while(curr.next!=null){
            length++;
            curr=curr.next;
        }
        k=k%length;
        if(k==0){
            return head;
        }
        curr.next=head;
        ListNode tail=head;
        int first=length-k;
        for(int i=1;i<first;i++){
            tail=tail.next;
        }
        ListNode newhead=tail.next;
        tail.next=null;
        return newhead;
    }
}
