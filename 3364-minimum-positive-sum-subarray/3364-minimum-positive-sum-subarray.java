class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int mini = Integer.MAX_VALUE;
        for (int size = l; size <= r; size++) {
            for (int i = 0; i + size <= n; i++) {
                int sum = prefix[i + size] - prefix[i]; // sum of window [i, i+size-1]
                if (sum > 0) {
                    mini = Math.min(mini, sum);
                }
            }
        }
        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
}