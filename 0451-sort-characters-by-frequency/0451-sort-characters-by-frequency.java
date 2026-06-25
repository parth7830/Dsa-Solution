class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        Character[] keys = hm.keySet().toArray(new Character[0]);
        Arrays.sort(keys,(a,b) -> hm.get(b) - hm.get(a));
        StringBuilder sb = new StringBuilder();
        for(char c : keys){
            int freq = hm.get(c);
            for(int i = 0;i<freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}