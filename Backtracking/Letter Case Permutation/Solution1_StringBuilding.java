class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtrack("",s);
        return result;
    }
    public void backtrack(String p,String up){
        if(up.isEmpty()){
            result.add(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch>='0' && ch<='9'){
            backtrack(p+ch,up.substring(1));
        }
        else{
            backtrack(p+ch,up.substring(1));
            if(ch>='a' && ch<='z'){
                backtrack(p+(char)(ch-32),up.substring(1));
            }
            else{
                backtrack(p+(char)(ch+32),up.substring(1));
            }
        }
    }
}
