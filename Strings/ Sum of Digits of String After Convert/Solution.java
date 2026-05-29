//1945. Sum of Digits of String After Convert

class Solution {
    public int getLucky(String s, int k) {
        
        int numb=0;
        for(int i=0;i<s.length();i++){
            int temp=s.charAt(i)-'a'+1;
            while(temp!=0){
                numb+=temp%10;
                temp/=10;
            }
        }
        
        while(k>1){
            int temp=numb;
            int newnumb=0;
            while(temp!=0){
                newnumb+=temp%10;
                temp/=10;
            }
            numb=newnumb;
            k--;
        }
        return numb;
    }
}
