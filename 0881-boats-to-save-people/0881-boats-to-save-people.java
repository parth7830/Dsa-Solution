class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int low = 0;
        int high = n-1;
        int cnt = 0;
        while(low <= high){
            if(people[low]+people[high] <= limit){
                low++;
            }
            cnt++;
            high--;
        }
        return cnt;
    }
}