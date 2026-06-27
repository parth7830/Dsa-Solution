class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int n =nums.length;
        int cnt = 0;
        int prod = 1;
        int left = 0;
        for(int i = 0;i<n;i++){
            prod *= nums[i];
            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            cnt += i-left+1;
        }
        return cnt;
    }
}