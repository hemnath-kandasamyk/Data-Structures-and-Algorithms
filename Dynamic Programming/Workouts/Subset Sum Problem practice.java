import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(fun(nums,nums.length-1,70));
        subsetSum(nums,4); 
    }

    public static  boolean fun(int[] nums,int idx,int target){
        if(idx==0){
            return nums[idx]==target;
        }
        if(target==0){
            return true;
        }
        if(target<0){
            return false;
        }
        boolean pick = fun(nums,idx-1,target-nums[idx]);
        boolean notpick = fun(nums,idx-1,target);

        return pick || notpick;
    }

    public static boolean subsetSum(int[] nums, int target) {

    int n = nums.length;

    boolean[][] dp = new boolean[n][target + 1];

    // Target = 0 is always possible
    for (int i = 0; i < n; i++) {
        dp[i][0] = true;
    }

    // First element
    if (nums[0] <= target) {
        dp[0][nums[0]] = true;
    }
    display(dp);
    // Fill the table
    for (int i = 1; i < n; i++) {

        for (int t = 1; t <= target; t++) {

            boolean notPick = dp[i - 1][t];

            boolean pick = false;

            if (nums[i] <= t) {
                pick = dp[i - 1][t - nums[i]];
            }

            dp[i][t] = pick || notPick;
            display(dp);
        }
    }

    return dp[n - 1][target];
    }

    public static void display(boolean[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print((mat[i][j])?"T ":"F ");
            }
            System.out.println();
        }
        for(int i=0;i<=20;i++){
            System.out.print('_');
        }
        System.out.println();
    }
}
