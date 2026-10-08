// 301. Remove Invalid Parentheses

class Solution {

    Set<String> set = new HashSet<>();
    StringBuilder curr = new StringBuilder();
    int maxlength = 0;

    public List<String> removeInvalidParentheses(String s) {

        dfs(s.toCharArray(),0,0);

        List<String>  result = new ArrayList<>();

        for(String i : set){
            if(i.length() == maxlength){
                result.add(i);
            }
        }

        return result;
    }

    public void dfs(char[] nums,int index,int depth){

        if(depth<0){
            return;
        }

        if(index==nums.length){
            if(depth==0){
                set.add(curr.toString());
                maxlength = Math.max(curr.length(),maxlength);
            }
            return;
        }


        if(nums[index] != '(' && nums[index] != ')'){
            curr.append(nums[index]);
            dfs(nums,index+1,depth);
            curr.deleteCharAt(curr.length()-1);
        }
        else{
            dfs(nums,index+1,depth);
            curr.append(nums[index]);
            if(nums[index]=='('){
                dfs(nums,index+1,depth+1);
            }
            else{
                dfs(nums,index+1,depth-1);
            }
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
