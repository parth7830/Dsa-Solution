class Solution {
    private int atmost(int[] nums,int goal){
        if(goal < 0 ) return 0;
        int n = nums.length;
        int cnt = 0;
        int low = 0;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            while(sum > goal){
                sum -= nums[low++];
            }
            cnt += i-low+1;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal) - atmost(nums,goal-1);
    }
}