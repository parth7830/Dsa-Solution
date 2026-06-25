class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int maxi = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i < n; i++){
            hm.put(fruits[i],hm.getOrDefault(fruits[i],0)+1);
            while(hm.size() > 2){
                hm.put(fruits[left],hm.get(fruits[left])-1);
                if(hm.get(fruits[left]) == 0){
                    hm.remove(fruits[left]);
                }
                left++;
            }
            maxi = Math.max(maxi,i-left+1);
        }
        return maxi;
    }
}