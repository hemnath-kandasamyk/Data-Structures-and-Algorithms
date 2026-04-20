class Solution {
    private int sum=0;
    public void dfs(TreeNode root){
     if(root==null){
        return ;
     }
     dfs(root.right);
     int temp=root.val;
     root.val+=sum;
     sum+=temp;
     dfs(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
}
