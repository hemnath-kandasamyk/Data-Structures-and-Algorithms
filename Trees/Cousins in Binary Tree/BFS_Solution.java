//993. Cousins in Binary Tree
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            boolean cousin1 = false;
            boolean cousin2 = false;

            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();

                if(curr.left!=null){
                    queue.add(curr.left);

                    if(curr.left.val == x){
                        cousin1 = true;
                    }
                    if(curr.left.val == y){
                        cousin2 = true;
                    }
                }

                if(curr.right!=null){
                    queue.add(curr.right);

                    if(curr.right.val==x){
                        cousin1=true;
                    }
                    if(curr.right.val==y){
                        cousin2 = true;
                    }
                }

                if(curr.left != null && curr.right !=null){

                    if((curr.left.val==x && curr.right.val==y) || (curr.right.val == x && curr.left.val==y)){
                        return false;
                    }
                }
                if(cousin1 && cousin2){
                    return true;
                }
            }
            if(cousin1 || cousin2){
                    return false;
            }
        }

        return false;
    }
}
