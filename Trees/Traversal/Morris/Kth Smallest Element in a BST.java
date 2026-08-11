//230. Kth Smallest Element in a BST
class Solution {
    public int kthSmallest(TreeNode root, int k) {
          
        TreeNode curr = root;
        int count =0;

        while(curr != null){

            if(curr.left==null){
                count++;
                if(count==k){
                    return curr.val;
                }
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
                    count++;
                    if(count==k){
                        return curr.val;
                    }
                    curr = curr.right;
                    
                }
            }
        }
        return 0;
    }
}
