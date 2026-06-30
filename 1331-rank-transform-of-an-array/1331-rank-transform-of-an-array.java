class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr) pq.offer(num);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int rank = 1;
        while(!pq.isEmpty()){
            int num = pq.poll();
            if(!hm.containsKey(num)){
                hm.put(num,rank++);
            }
        }
        for(int i = 0;i<arr.length;i++){
            result[i] = hm.get(arr[i]);
        }
        return result;
    }
}