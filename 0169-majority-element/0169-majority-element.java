class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
         int cand = 0;
            int cnt = 0;
        for(int num : nums){
            if(cnt == 0){
                cand = num;
            }
            if(num == cand){
                cnt++;
            }else{
                cnt--;
            }
        }
        return cand;
    }
}