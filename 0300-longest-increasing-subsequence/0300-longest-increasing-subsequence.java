class Solution {
    // private int[][] dp;

    // private int count(int[] nums, int ind, int prev) {
    //     if (ind == nums.length)
    //         return 0;
    //     if (dp[ind][prev + 1] != -1)
    //         return dp[ind][prev + 1];
    //     int len = 0 + count(nums, ind + 1, prev);
    //     int take = 0;
    //     if (prev == -1 || nums[ind] > nums[prev]) {
    //         take = 1 + count(nums, ind + 1, ind);
    //     }
    //     return dp[ind][prev + 1] = Math.max(take, len);
    // }

    public int lengthOfLIS(int[] nums) {
        // dp = new int[nums.length+1][nums.length + 1];
        // int n = nums.length;
        // for (int ind = n - 1; ind >= 0; ind--) {
        //     for (int prev = ind - 1; prev >= -1; prev--) {
        //         int len = dp[ind+1][prev+1];
        //         int take = 0;
        //         if (prev == -1 || nums[ind] > nums[prev]) {
        //             take = 1 + dp[ind+1][ind+1];
        //         }
        //         dp[ind][prev+1] = Math.max(len,take);
        //     }
        // }
        // return dp[0][0];
        int n = nums.length;
        int[] dp = new int[n];
        int maxi = 1;
        for(int ind = 0;ind<n;ind++){
            dp[ind] = 1;
            for(int prev = 0;prev < ind;prev++){
                if(nums[prev] < nums[ind]){
                    dp[ind] = Math.max(dp[ind],1+dp[prev]);
                }
            }
            maxi = Math.max(maxi,dp[ind]);
        }
        return maxi;
    }
}