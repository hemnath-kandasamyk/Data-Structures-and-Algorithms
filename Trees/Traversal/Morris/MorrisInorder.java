class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null){

            if(curr.left==null){
                list.add(curr.val);
                curr = curr.right;
            }

            else {
                TreeNode process = curr.left;

                while(process.right != null && process.right!=curr){
                    process = process.right;   
                }

                if(process.right == null){
                    process.right = curr;
                    curr = curr.left;
                } 
                else{
                    process.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                    
                }
            }
        }
        return list;        
    }
}
