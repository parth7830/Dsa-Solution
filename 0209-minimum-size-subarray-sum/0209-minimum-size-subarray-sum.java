class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int sum = 0;
        int left = 0;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while(sum >= target) {
                mini = Math.min(mini, i-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return mini == Integer.MAX_VALUE?0:mini;
    }
}