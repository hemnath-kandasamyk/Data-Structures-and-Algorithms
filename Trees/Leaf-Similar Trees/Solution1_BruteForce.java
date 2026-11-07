class Solution {
  
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        trav(root1,list1);
        trav(root2,list2);

        if(!list1.equals(list2)){
            return false;
        }
        
        return true;
    }

    public void trav(TreeNode root,ArrayList<Integer> list){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            list.add(root.val);
        }

        trav(root.left,list);
        trav(root.right,list);
    }
}
