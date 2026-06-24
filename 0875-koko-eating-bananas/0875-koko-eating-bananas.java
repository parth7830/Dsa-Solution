class Solution {
    static long cal(int[] piles,int mid){
        int n = piles.length;
        long sum = 0;
        for(int i : piles){
            sum += (int) Math.ceil((double) i/mid);
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxi = 0;
        for(int p : piles){
            maxi = Math.max(maxi,p);
        }
        int ans = maxi;
        int low = 1;
        int high = maxi;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(cal(piles,mid) <= h){
                ans = mid;
                high  = mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}