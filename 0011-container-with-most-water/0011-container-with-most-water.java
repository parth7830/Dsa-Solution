class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int maxi = 0;
        while(l<r){
            int h = Math.min(height[l],height[r]);
            int width = r-l;
            maxi = Math.max(maxi,h*width);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxi;
    }
}