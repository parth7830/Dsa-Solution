import java.util.*;

class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] ans = new long[n];

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;

        int i = 0;

        while (i < n) {

            int j = i;

            // Assign answer first
            while (j < n && arr[j][0] == arr[i][0]) {
                ans[arr[j][2]] = sum;
                j++;
            }

            // Then insert all elements of this group
            while (i < j) {
                pq.offer(arr[i][1]);
                sum += arr[i][1];

                if (pq.size() > k) {
                    sum -= pq.poll();
                }

                i++;
            }
        }

        return ans;
    }
}