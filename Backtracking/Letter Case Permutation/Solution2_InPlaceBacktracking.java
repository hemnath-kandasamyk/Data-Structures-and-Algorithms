class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtrack(s.toCharArray(),0);
        return result;
    }
    public void backtrack(char[] letters, int index){
        if(index==letters.length){
            result.add(new String(letters));
            return;
        }
        backtrack(letters,index+1);
        char ch = letters[index];
        if(!(ch>='0' && ch<='9')){
            letters[index]=(ch>='a' && ch<='z')?(char)(ch-32):(char)(ch+32);
            backtrack(letters,index+1);
            letters[index]=(ch>='a' && ch<='z')?(char)(ch-32):(char)(ch+32);
        }
    }
}
