class Solution {
    public int[] separateDigits(int[] nums) {
      Stack<Integer> stack=new Stack<>();
      for(int i=nums.length-1;i>=0;i--){
        int temp=nums[i];
        if(temp==0){
          stack.push(0);
        }
        while(temp!=0){
            stack.push(temp%10);
            temp/=10;
        }
      }
      int n=stack.size();
      int[] result=new int[n];
      for(int i=0;i<n;i++){
        result[i]=stack.pop();
      }
      return result;
    }
}
