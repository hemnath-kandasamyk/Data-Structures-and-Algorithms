class Solution(object):
    def sortedListToBST(self, head):
        if head is None :
            return None
        if head.next is None:
            return TreeNode(head.val)
    
        slow = fast = prev =head

        while fast is not None and fast.next is not None:
            fast = fast.next.next
            prev = slow
            slow=slow.next

        root = TreeNode(slow.val)
        prev.next = None

        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(slow.next)

        return root              
        
