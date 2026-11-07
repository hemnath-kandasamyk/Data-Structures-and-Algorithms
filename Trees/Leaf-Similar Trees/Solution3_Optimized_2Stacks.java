class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root1);
        stack2.push(root2);

        while(!stack1.isEmpty() && !stack2.isEmpty()){

            int leaf1 = getLeaf(stack1);
            int leaf2 = getLeaf(stack2);

            if(leaf1 != leaf2){
                return false;
            }
        }

        return (stack1.isEmpty() && stack2.isEmpty());
    }

    public int getLeaf(Stack<TreeNode> stack){

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(curr.left == null && curr.right == null){
                return curr.val;
            }

            if(curr.right != null){
                stack.push(curr.right);
            }

            if(curr.left != null){
                stack.push(curr.left);
            }
        }

        return -1;
    }
}
