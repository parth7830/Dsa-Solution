class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int cnt = 0;
        int n = nums.length;
        int prefixsum = 0;
        for(int i = 0;i<n;i++){
            prefixsum += nums[i];
            cnt += hm.getOrDefault(prefixsum-goal,0);
            hm.put(prefixsum,hm.getOrDefault(prefixsum,0)+1);
        }
        return cnt;
    }
}