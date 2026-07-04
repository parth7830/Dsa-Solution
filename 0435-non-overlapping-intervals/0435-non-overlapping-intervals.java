class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int cnt = 0;
        List<int[]> al = new ArrayList<>();
        al.add(intervals[0]);
        int mini = Integer.MAX_VALUE;
        for(int i = 1;i<n;i++){
            int[] current = intervals[i];
            int[] last = al.get(al.size()-1);
            if(current[0] < last[1]){
                cnt++;
            }else{
                al.add(intervals[i]);
            }
        } 
        return cnt;
    }
}