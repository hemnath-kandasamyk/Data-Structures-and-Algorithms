class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,new ArrayList<>(),0);
        return result;
    }
    
    public void backtrack(int[] ary,int t,List<Integer>l1,int idx){
        if(t<0){
            return;
        }
        if(t==0){
            result.add(new ArrayList<>(l1));
            return;
        }
        for(int i=idx;i<ary.length;i++){
            l1.add(ary[i]);
            backtrack(ary,t-ary[i],l1,i);
            l1.remove(l1.size()-1);
        }
    }
}
