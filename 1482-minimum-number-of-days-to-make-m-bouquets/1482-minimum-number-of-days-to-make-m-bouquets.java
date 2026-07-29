class Solution {

    static boolean canMake(int[] bloomDay, int day, int m, int k) {

        int count = 0;
        int bouquets = 0;

        for(int i = 0; i < bloomDay.length; i++) {

            if(bloomDay[i] <= day) {
                count++;
                if(count == k) {
                    bouquets++;
                    count = 0;
                }
            } 
            else {
                count = 0;
            }

        }

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m * k > bloomDay.length) return -1;

        int low = 1;
        int high = 0;

        for(int i : bloomDay) {
            high = Math.max(high, i);
        }

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(canMake(bloomDay, mid, m, k)) {
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }

        }

        return low;
    }
}