class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];

        // Step 1: build the matrix, same style as your code
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) matrix[i][j] = 0;
                else matrix[i][j] = (int) 1e9;
            }
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            matrix[u][v] = Math.min(matrix[u][v], w);
            matrix[v][u] = Math.min(matrix[v][u], w);
        }

        // Step 2: Floyd-Warshall (same triple loop structure as your image)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],
                                             matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // Step 3: count reachable cities within threshold, for each city
        int bestCity = -1;
        int minReachable = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minReachable) {
                minReachable = count;
                bestCity = i;
            }
        }

        return bestCity;
    }
}