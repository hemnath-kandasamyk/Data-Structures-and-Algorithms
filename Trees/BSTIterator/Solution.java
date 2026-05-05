class BSTIterator {
    List<Integer> list=new ArrayList<>();
    int idx=0;
    public BSTIterator(TreeNode root) {
         back(root);
    }
    public void back(TreeNode root){
        if(root==null){
            return;
        }
        back(root.left);
        list.add(root.val);
        back(root.right);
    }
    public int next() {
        return list.get(idx++);
    }
    
    public boolean hasNext() {
        return (idx<list.size());
    }
}
