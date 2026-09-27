// 1190. Reverse Substrings Between Each Pair of Parentheses

class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> list  = new ArrayList<>();

        for(char i : s.toCharArray()){

            if(i==')'){

                while(!stack.isEmpty() && stack.peek()!='('){
                    list.add(stack.pop());
                }

                stack.pop();

                for(int j=0;j<list.size();j++){
                    stack.push(list.get(j));
                }
                list.clear();

            }

            else{
                stack.push(i);
            }

        }

        char[] res = new char[stack.size()];
        int index = stack.size()-1;

        while(!stack.isEmpty()){
            res[index--] = stack.pop();
        }

        return new String(res);
    }
}
