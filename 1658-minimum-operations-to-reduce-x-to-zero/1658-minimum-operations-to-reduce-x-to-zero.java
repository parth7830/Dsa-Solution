class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) return -1;
        if (target == 0) return n;

        int left = 0;
        int sum = 0;
        int maxi = -1;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxi = Math.max(maxi, i - left + 1);
            }
        }

        if (maxi == -1) return -1;

        return n - maxi;
    }
}