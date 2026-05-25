class Solution {
    public int reverse(int x) {
      long rev=0L;
      int temp=x;
      while(temp!=0){
          if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE){
              return 0;
          }
          rev=(rev *10)+(temp%10);
          temp=temp/10;
      }
      if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE){
              return 0;
      }
      return (int)rev;  
    }
}
