class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode prev = head;
        int rank = 2;

        while(prev!=null && prev.next != null){
            int count =0;
            ListNode temp = prev.next;

            while(temp!=null && count<rank){
                count++;
                temp=temp.next;
            }

            if(count%2==0){
                prev.next = reverse(prev.next,count);
            }

            for(int i=0;i<count;i++){
                prev=prev.next;
            }
            rank++;
        }
        return head;
    }

    ListNode reverse(ListNode head,int count){

        if(head == null){
            return null;
        }

        ListNode rev = null;
        ListNode curr = head;
        ListNode edge = head;

        while(curr != null && count-->0){

            ListNode temp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = temp;
        }
        edge.next=curr;
        return rev;
    }
}
