class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int curEnd = 0;      // end of current jump range
        int farthest = 0;    // farthest reachable in current level

        for (int i = 0; i < n - 1; i++) {   // stop at n-2, last index no jump needed
            farthest = Math.max(farthest, i + nums[i]);

            if (i == curEnd) {               // reached end of current level
                jumps++;                     // must take a jump
                curEnd = farthest;           // extend to farthest reachable

                if (curEnd >= n - 1) break;  // reached or passed end
            }
        }

        return jumps;
    }
}