class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int cnt = 0;
        int ps = 0;
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i = 0;i<n;i++){
            if(nums[i] %2!= 0){
                cnt++;
            }
            ans += hm.getOrDefault(cnt - k,0);
            hm.put(cnt,hm.getOrDefault(cnt,0)+1);
        }
        return ans;
    }
}