class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for characters in t
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0;
        int count = t.length(); // total chars we need to match
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            // If this char is needed, decrease count
            if (need[r] > 0) {
                count--;
            }
            need[r]--; // always decrease, even if not needed
            right++;

            // When all chars are matched
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                need[l]++; // put back the char
                if (need[l] > 0) {
                    count++; // window no longer valid
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
