class Solution {
    private int[][] dp;
    private int count(int[] nums, int ind, int prev){
        if(ind == nums.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev+1];
        int len = 0 + count(nums, ind + 1, prev);
        int take = 0;
        if(prev == -1 || nums[ind] > nums[prev]){
            take = 1+count(nums,ind+1,ind);
        }
        return dp[ind][prev + 1] = Math.max(take,len);
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length+1];
        for(int row[] : dp) Arrays.fill(row,-1);
        return count(nums,0,-1);
    }
}