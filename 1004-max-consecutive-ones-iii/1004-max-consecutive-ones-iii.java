class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int cnt = 0;     // count of zeros in current window
        int maxi = 0;

        for (int high = 0; high < n; high++) {

            if (nums[high] == 0) {
                cnt++;
            }

            // shrink window if zeros exceed k
            while (cnt > k) {
                if (nums[low] == 0) {
                    cnt--;
                }
                low++;
            }

            // window length
            maxi = Math.max(maxi, high - low + 1);
        }

        return maxi;
    }
}

