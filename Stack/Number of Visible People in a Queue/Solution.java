class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<heights[i]){
                stack.pop();
                res[i]++;
            }
            if(!stack.isEmpty()){
                res[i]++;
            }
            stack.push(heights[i]);
        }
        return res;
    }
}
