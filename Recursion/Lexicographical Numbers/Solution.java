//386. Lexicographical Numbers
class Solution {
    List<Integer> numbers = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<=9;i++){
            backtrack(i,n);
        }
        return  numbers;
    }

    public void backtrack(int n,int k){
        if(n>k){
            return;
        }
        numbers.add(n);
        for(int i=0;i<=9;i++){
            backtrack(n*10 + i,k);
        }
    }
}
