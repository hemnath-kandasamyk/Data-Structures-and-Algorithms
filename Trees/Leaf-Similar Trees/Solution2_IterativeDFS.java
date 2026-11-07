class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        stack.push(root1);

        while(!stack.isEmpty()){

            TreeNode curr = stack.pop();

            if(curr.left == null && curr.right == null){
                list.add(curr.val);
            }

            if(curr.right != null){
                stack.push(curr.right);
            }

            if(curr.left != null){
                stack.push(curr.left);
            }
        }

        int index = 0;

        stack.push(root2);

        while(!stack.isEmpty()){

            TreeNode curr = stack.pop();

            if(curr.left == null && curr.right == null){
                if(index>=list.size() || list.get(index) != curr.val){
                    return false;
                }
                index++;
            }

            if(curr.right != null){
                stack.push(curr.right);
            }

            if(curr.left != null){
                stack.push(curr.left);
            }
        }

        return index == list.size();
    }
}
