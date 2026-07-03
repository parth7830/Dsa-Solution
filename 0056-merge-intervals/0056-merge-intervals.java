class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> al = new ArrayList<>();
        al.add(intervals[0]);
        for(int i = 1;i<n;i++){
            int[] current = intervals[i];
            int[] last = al.get(al.size()-1);
            if(current[0] <= last[1]){
                last[1] = Math.max(last[1],current[1]);
            }else{
                al.add(intervals[i]);
            }
        }
        return al.toArray(new int[al.size()][]);
    }
}