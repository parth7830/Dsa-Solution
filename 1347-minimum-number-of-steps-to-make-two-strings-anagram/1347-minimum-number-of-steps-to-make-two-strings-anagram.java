class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c : s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(char c : t.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)-1);
        }

        int steps = 0;
        for(int val : hm.values()){
            if(val > 0) steps += val;
        }
        return steps;
    }
}