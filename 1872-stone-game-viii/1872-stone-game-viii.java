class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        if (n == 1) return 0;

        // prefix sums
        int[] S = new int[n + 1];
        for (int i = 0; i < n; i++) {
            S[i + 1] = S[i] + stones[i];
        }

        int[] dp = new int[n + 1];        // dp[n] = 0
        int[] suffixMax = new int[n + 2]; // suffixMax[j] = max_{k=j..n} (S[k]-dp[k])
        suffixMax[n] = S[n] - dp[n];        // f(n)
        suffixMax[n + 1] = Integer.MIN_VALUE;  // sentinel (unused for range check but safe)

        for (int j = n - 1; j >= 1; j--) {
            dp[j] = suffixMax[j + 1];                 // dp[j] = max_{k=j+1..n} f(k)
            int fj = S[j] - dp[j];
            suffixMax[j] = Math.max(fj, suffixMax[j + 1]);
        }

        // dp[0] must start the max range at j = 2 (need x > 1 with no merged stone yet)
        return suffixMax[2];
    }
}