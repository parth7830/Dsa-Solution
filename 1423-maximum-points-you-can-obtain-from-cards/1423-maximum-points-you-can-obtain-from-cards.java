class Solution {
    public int maxScore(int[] cardPoints, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = cardPoints.length;
        int lsum = 0;
        int rsum = 0;
        int maxi = 0;
        for(int i = 0;i<k;i++){
            lsum = lsum + cardPoints[i];
            maxi = lsum;
        }
        int rindex = n-1;
        for(int i = k-1;i>=0;i--){
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rindex];
            rindex--;
            maxi = Math.max(maxi,lsum+rsum);
        }
        return maxi;
    }
}