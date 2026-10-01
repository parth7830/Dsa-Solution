class Solution {
    private static int[][] dp;
    private static int offset;
    private static int count(int[] nums, int k, int n, int i, int sum){
        if(i == n) return sum == k ? 1 : 0;
        if(dp[i][sum + offset] != -1) return dp[i][sum + offset];
        int sub = count(nums,k,n,i+1,sum-nums[i]);
        int add = count(nums,k,n,i+1,sum+nums[i]);
        return dp[i][sum + offset] = sub + add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int x : nums) total += x;
        offset = total;
        dp = new int[n][2 * total +1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return count(nums,target,n,0,0);
    }
}