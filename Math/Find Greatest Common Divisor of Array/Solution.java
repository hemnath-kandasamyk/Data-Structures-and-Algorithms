class Solution {
    public int findGCD(int[] nums) {
        int maximum_element = Integer.MIN_VALUE;
        int minimum_element = Integer.MAX_VALUE;

        for(int i : nums){
            maximum_element = Math.max(maximum_element,i);
            minimum_element = Math.min(minimum_element,i);
        }
        return gcd(maximum_element,minimum_element);
    }

    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
