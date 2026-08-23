class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        // Count sum and '?' for each half
        int sumLeft = 0, sumRight = 0;
        int qLeft = 0, qRight = 0;

        // First half
        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') {
                qLeft++;
            } else {
                sumLeft += num.charAt(i) - '0';
            }
        }

        // Second half
        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') {
                qRight++;
            } else {
                sumRight += num.charAt(i) - '0';
            }
        }

        /*
         * Key Math:
         *
         * Each '?' can contribute 0-9
         * Optimal play: each '?' contributes 4.5 avg
         * (Bob replaces with 9-x to mirror Alice's x)
         *
         * Bob wins ONLY if:
         * sumLeft + qLeft * 4.5 == sumRight + qRight * 4.5
         *
         * Multiply by 2 to avoid decimals:
         * 2*sumLeft + qLeft*9 == 2*sumRight + qRight*9
         *
         * Alice wins (return true) if NOT equal:
         */

        return (2 * sumLeft + qLeft * 9)
            != (2 * sumRight + qRight * 9);
    }
}