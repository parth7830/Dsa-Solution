class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left  = new int[n];
        int[] right = new int[n];

        // Pass 1: left to right
        // satisfy: if rating[i] > rating[i-1] → more candy than left
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;             // reset to minimum
            }
        }

        // Pass 2: right to left
        // satisfy: if rating[i] > rating[i+1] → more candy than right
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;            // reset to minimum
            }
        }

        // Final: take max of both passes
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.max(left[i], right[i]);
        }

        return total;
    }
}