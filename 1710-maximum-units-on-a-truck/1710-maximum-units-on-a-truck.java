class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) -> b[1] - a[1]);
        int total  = 0;
        int rem = truckSize;
        for(int[] box : boxTypes){
            if(rem == 0) break;
            int iw = box[0];
            int iv = box[1];
            if(rem >= iw){
                total += iv * iw;
                rem -= iw;
            }else{
                total += rem * iv;
                rem = 0;
            }
        }
        return total;
    }
}