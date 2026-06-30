class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        for(int key : hm.keySet()){
            pq.offer(new int[]{key,hm.get(key)});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = k-1;i>=0;i--){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}