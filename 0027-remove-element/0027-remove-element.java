class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cnt = 0;
        int idx = 0;
        int[] result = new int[n];
        for(int i = 0;i<n;i++){
            if(nums[i] == val){
                cnt++;
            }else{
                result[idx] = nums[i];
                idx++;
            }
        }
        for(int i = 0;i<idx;i++){
            nums[i] = result[i];
        }
        return idx;
    }
}