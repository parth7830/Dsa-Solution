class Solution {
    public long countCommas(long n) {
        long total = 0;
        long lower = 1; // start of 1-digit numbers

        for (int d = 1; lower <= n; d++) {
            long upper = lower * 10 - 1; // largest d-digit number
            long rangeUpper = Math.min(upper, n);
            long count = rangeUpper - lower + 1;

            int commasPerNumber = (d - 1) / 3;
            total += count * commasPerNumber;

            lower = upper + 1; // move to next digit-length range
        }

        return total;
    }
}