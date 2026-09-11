class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> distinctNumbers = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int hundreds = digits[i];
                    int tens = digits[j];
                    int ones = digits[k];

                    if (hundreds == 0) continue;       // no leading zero
                    if (ones % 2 != 0) continue;        // must be even

                    int number = hundreds * 100 + tens * 10 + ones;
                    distinctNumbers.add(number);
                }
            }
        }

        return distinctNumbers.size();
    }
}