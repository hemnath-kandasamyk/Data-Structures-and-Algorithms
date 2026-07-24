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
    public int[] nextLargerNodes(ListNode head) {

        ListNode rev = null;
        ListNode curr = head;
        int n = 0;
        while(curr != null){

            ListNode temp = curr.next;
            curr.next=rev;
            rev=curr;
            curr=temp;
            n++;
        }

        curr=rev;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        int index =n-1;

        while(curr!=null){
            
            while(!stack.isEmpty() && curr.val>=stack.peek()){
                stack.pop();
            }
            res[index--]=(stack.isEmpty())?0:stack.peek();
            stack.push(curr.val);
            curr = curr.next;
        }
        return res;
    }
}
