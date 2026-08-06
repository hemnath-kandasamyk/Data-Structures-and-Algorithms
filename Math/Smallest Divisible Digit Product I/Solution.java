//3345. Smallest Divisible Digit Product I
class Solution {
    public int smallestNumber(int n, int t) {
        int temp = n;
        while((product(temp)%t!=0)){
            temp++;
        }
        return temp;
    }

    public int product(int n){
        int temp = n;
        int product = 1;

        while(temp!=0){
            product *= (temp%10);
            temp/=10;
        }
        return product;
    }
}
