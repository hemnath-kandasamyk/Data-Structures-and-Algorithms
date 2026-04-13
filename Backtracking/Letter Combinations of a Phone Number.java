class Solution {
    private static final String[] ary={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result =new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        backtrack("",digits);
        return result;
    }
    public void backtrack(String p, String up){
        if(up.isEmpty()){
            result.add(p);
            return;
        }
        int num=up.charAt(0)-'0';
        for(int i=0;i<ary[num].length();i++){
            backtrack(p+ary[num].charAt(i),up.substring(1));
        }
    }
}
