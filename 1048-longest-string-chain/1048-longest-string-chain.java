class Solution {
    private static int[][] dp;
    private static boolean isPred(String a, String b) {
        if (b.length() != a.length() + 1) return false;
        int i = 0, j = 0;
        while (j < b.length()) {
            if (i < a.length() && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j++; // b ka ek letter skip
            }
        }
        return i == a.length();
    }
    private static int count(String[] nums,int ind, int prev, int n){
        if(ind == n) return 0;
        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        int nt = 0 + count(nums,ind+1,prev,n);
        String s = nums[ind];
        int take = 0;
        if(prev == -1 || isPred(nums[prev],nums[ind])){
            take = 1 + count(nums,ind + 1,ind,n);
        }
        return dp[ind][prev+1] = Math.max(nt,take);
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        return count(words,0,-1,n);
    }
}