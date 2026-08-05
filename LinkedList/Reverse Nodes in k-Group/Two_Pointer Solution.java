class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0,head);

        ListNode slow = dummy;
        ListNode fast = head;
        ListNode prev = dummy;
        ListNode Next = head;

        while (fast != null){

            int count =0;
            while(count<k && fast!=null){
                count++;
                fast = fast.next;
                prev = prev.next;
            }

            if(count==k){

                ListNode rev = null;
                ListNode tail = Next;
                ListNode current = Next;

                while(count>0 && current!=null){
                    ListNode temp = current.next;
                    current.next=rev;
                    rev = current;
                    current = temp;
                    count--;
                }

                tail.next = fast;
                slow.next=rev;
                slow = tail;
                prev = slow;
                Next = fast;
            }
        }
        return dummy.next;
    }
}
