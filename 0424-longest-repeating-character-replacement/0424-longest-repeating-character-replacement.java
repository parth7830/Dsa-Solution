class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int maxfreq = 0;
        int maxi = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int r = 0;r<n;r++){
            char c = s.charAt(r);
            hm.put(c,hm.getOrDefault(c,0)+1);
            maxfreq = Math.max(maxfreq,hm.get(c));
            while((r-l+1) - maxfreq > k){
                char t = s.charAt(l);
                hm.put(t,hm.get(t)-1);
                if(hm.get(t) == 0){
                    hm.remove(t);
                }
                l++;
            }
            maxi = Math.max(maxi,r-l+1);
        }
        return maxi;
    }
}