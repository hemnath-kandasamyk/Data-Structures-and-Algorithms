class Solution(object):
    def leafSimilar(self, root1, root2):
        
        stack1 = [root1]
        stack2 = [root2]

        while True:

            leaf1 = self.getLeaf(stack1)
            leaf2 = self.getLeaf(stack2)

            if leaf1 is None and leaf2 is None:
                return True

            if leaf1 != leaf2:
                return False
            
            if leaf1 is None or leaf2 is None:
                return False

    def getLeaf(self,stack):

        while stack:

            curr = stack.pop()

            if curr.left is None and curr.right is None:
                return curr.val
            
            if curr.right is not None:
                stack.append(curr.right)

            if curr.left is not None:
                stack.append(curr.left)

        return None

        
