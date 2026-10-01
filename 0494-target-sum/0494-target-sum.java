class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;

        int offset = total;
        int[][] dp = new int[n + 1][2 * total + 1];

        // base case: sum = 0 at start
        dp[0][offset] = 1;

        for (int i = 0; i < n; i++) {
            for (int sum = -total; sum <= total; sum++) {
                if (dp[i][sum + offset] != 0) {
                    int plus = sum + nums[i];
                    int minus = sum - nums[i];
                    dp[i + 1][plus + offset] += dp[i][sum + offset];
                    dp[i + 1][minus + offset] += dp[i][sum + offset];
                }
            }
        }

        return (target > total || target < -total) ? 0 : dp[n][target + offset];
    }
}
