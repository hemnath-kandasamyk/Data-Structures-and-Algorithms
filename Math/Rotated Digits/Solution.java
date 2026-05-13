//788. Rotated Digits
class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            
            boolean change=false;
            boolean valid =true;
            int temp=i;
            while(temp>0){
                int digit=temp%10;
                if(digit==3 || digit==4 || digit==7){
                    valid=false;
                    break;
                }
                if(digit==2 || digit==5 || digit==6 || digit==9){
                    change=true;
                }
                temp/=10;
            }
            if(valid && change){
                count++;
            }
        }
        return count;
    }
}
