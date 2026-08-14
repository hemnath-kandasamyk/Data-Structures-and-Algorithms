class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    private int maxfreq =0;
    private int count =0;

    public int[] findMode(TreeNode root) {
        backtrack(root);
        int[] res = new int[count];

        int index = 0;

        for(int key : map.keySet()){
            if(map.get(key)==maxfreq){
                res[index++]=key;
            }
        }

        return res;
    }

    public void backtrack(TreeNode root){

        if(root==null){
            return;
        }

        map.put(root.val,map.getOrDefault(root.val,0)+1);

        if(map.get(root.val)>maxfreq){
            maxfreq = map.get(root.val);
            count = 1;
        }
        else if(map.get(root.val)==maxfreq){
            count++;
        }
        backtrack(root.left);
        backtrack(root.right);
    }
}
