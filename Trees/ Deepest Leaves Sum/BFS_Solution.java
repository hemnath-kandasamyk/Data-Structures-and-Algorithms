// 1302. Deepest Leaves Sum

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int sum = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            int currentsum = 0;

            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();
                currentsum += current.val;

                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }
            sum = currentsum;
        }

        return sum;
    }
}
