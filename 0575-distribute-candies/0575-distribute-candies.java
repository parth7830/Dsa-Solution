class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int s : candyType){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        return Math.min(n/2,hm.size());
    }
}