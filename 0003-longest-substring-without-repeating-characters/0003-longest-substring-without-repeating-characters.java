class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxi = 0;
        int left = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(hm.containsKey(c) && hm.get(c) >= left){
                left = 1 + hm.get(c);
            }
            hm.put(c,i);
            maxi = Math.max(maxi,i-left+1);
        }
        return maxi;
    }
}