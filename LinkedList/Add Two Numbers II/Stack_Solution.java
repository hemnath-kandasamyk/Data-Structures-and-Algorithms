/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        int c=0;
        ListNode ans=null;
        ListNode curr=ans;
        while(!s1.isEmpty() || !s2.isEmpty() ||c!=0){
            int sum=c;
            if(!s1.isEmpty())sum+=s1.pop();
            if(!s2.isEmpty())sum+=s2.pop();
            ListNode hem=new ListNode(sum%10);
            if(curr==null){
                ans=hem;
                curr=ans;
            }
            else{
                curr.next=hem;
                curr=curr.next;
            }
            c=sum/10;
        }
        ListNode rev=null;
         curr=ans;
        while(curr!=null){
            ListNode nw=curr.next;
            curr.next=rev;
            rev=curr;
            curr=nw;
        }
        return rev;
    }
}
