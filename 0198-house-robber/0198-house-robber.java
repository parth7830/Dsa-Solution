class Solution {

    private static int solve(int ind, int[] arr,int[] dp) {

        if (ind == 0)
            return arr[0];

        if (ind < 0)
            return 0;
        if(dp[ind] != -1)return dp[ind];
        // Rob current house
        int left = arr[ind] + solve(ind - 2, arr,dp);

        // Don't rob current house
        int right = solve(ind - 1, arr, dp);

        return dp[ind] = Math.max(left, right);
    }

    public int rob(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n - 1, nums, dp);
    }
}