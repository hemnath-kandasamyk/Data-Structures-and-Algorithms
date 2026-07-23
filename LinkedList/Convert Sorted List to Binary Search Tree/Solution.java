class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        slow=slow.next;
        prev.next=null;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(slow);
        return root;
    }
}
