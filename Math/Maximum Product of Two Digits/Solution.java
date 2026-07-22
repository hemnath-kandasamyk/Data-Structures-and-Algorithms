class Solution {
    public int maxProduct(int n) {
        int max1 = -1;
        int max2 = -1;

        int temp = n;

        while(temp!=0){
            int curr = temp%10;
            temp/=10;

            if(curr>max1){
                max2=max1;
                max1=curr;
            }
            else if(curr>max2){
                max2=curr;
            }
        }
        return max1*max2;
    }
}
