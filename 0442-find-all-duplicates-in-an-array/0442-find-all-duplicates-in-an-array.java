class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int s : nums){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        for(int h : hm.keySet() ){
            if(hm.get(h) == 2){
                al.add(h);
            }
        }
        return al;
    }
}