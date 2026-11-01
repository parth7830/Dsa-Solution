class Solution {
    private int sum(int[] nums){
        int n = nums.length;
        int total = 0;
        for(int i = 0;i < n;i++){
            total += nums[i];
        }
        return total;
    }
    public int minMoves(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            mini = Math.min(mini,nums[i]);
        }
        return sum(nums) - n * mini;
    }
}