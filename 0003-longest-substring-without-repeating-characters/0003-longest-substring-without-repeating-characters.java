class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0;
        int maxi = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (hm.containsKey(c) && hm.get(c) >= i) {
                i = 1 + hm.get(c);
            }
            hm.put(c, j);
            maxi = Math.max(maxi, j - i + 1);
        }
        return maxi;
    }
}