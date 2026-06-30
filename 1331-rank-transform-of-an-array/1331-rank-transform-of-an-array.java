class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        int[] result = new int[arr.length];

        HashMap<Integer,Integer> hm = new HashMap<>();
        int rank = 1;
        for(int num : copy){
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