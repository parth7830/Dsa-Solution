class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0;
        int maxi = 0;
        int maxfreq = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            maxfreq = Math.max(maxfreq,hm.get(s.charAt(i)));
            while((i-low+1)-maxfreq > k){
                char c = s.charAt(low);
                hm.put(c,hm.get(c)-1);
                if(hm.get(c) == 0){
                    hm.remove(c);
                }
                low++;
            }
            maxi = Math.max(maxi,i-low+1);
        }
        return maxi;
    }
}