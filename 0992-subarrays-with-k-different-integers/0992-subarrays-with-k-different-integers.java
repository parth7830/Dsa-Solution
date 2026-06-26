class Solution {
    private int atmost(int[] nums,int k){
        int n = nums.length;
        int left = 0;
        int maxi = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            while(hm.size() > k){
                hm.put(nums[left],hm.get(nums[left])-1);
                if(hm.get(nums[left]) == 0){
                    hm.remove(nums[left]);
                }
                left++;
            }
            maxi += i-left+1;
        }
        return maxi;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
}