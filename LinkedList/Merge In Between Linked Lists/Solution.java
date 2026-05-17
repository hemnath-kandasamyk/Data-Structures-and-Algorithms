//1669. Merge In Between Linked Lists
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
       ListNode l2head=list2;
       ListNode l2tail=list2;
       while(l2tail!=null && l2tail.next!=null){
        l2tail=l2tail.next;
       }
       ListNode curr=list1;
       for(int i=1;i<a;i++){
        curr=curr.next;
       }
       ListNode temp=curr.next;
       curr.next=l2head;
       for(int i=a;i<=b;i++){
        temp=temp.next;
       } 
       l2tail.next=temp;
       return list1;
    }
}
