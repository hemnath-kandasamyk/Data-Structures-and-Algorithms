//3765. Complete Prime Number
class Solution {
    public boolean completePrime(int num) {

        int suffix = 0;
        int pow = 1;
        while(num>0){
            
            suffix = suffix + (num%10) * pow;
            pow = pow *10;
            
            if(!isPrime(suffix)){
                return false;
            }
            if(!isPrime(num)){
                return false;
            }
            num/=10;
        }
        return true;
    }

    public boolean isPrime(int x){

        if(x==0 || x==1){
            return false;
        }
        
        for(int i=2;i*i<=x;i++){
            if(x%i ==0){
                return false;
            }
        }
        return true;
    }
}
