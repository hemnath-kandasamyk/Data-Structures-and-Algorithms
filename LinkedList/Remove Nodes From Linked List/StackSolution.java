//2487. Remove Nodes From Linked List
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode curr=head;
        while(curr!=null){
            if(stack.isEmpty()){
                stack.push(curr.val);
            }
            else{
                while(!stack.isEmpty() && stack.peek()<curr.val){
                    stack.pop();
                }
                stack.push(curr.val);
            }
            curr=curr.next;
        }
        ListNode rev=null;
        curr=head;
        while(!stack.isEmpty()){
            ListNode temp=curr.next;
            curr.val=stack.pop();
            curr.next=rev;
            rev=curr;
            curr=temp;
        }
        return rev;
    }
}
